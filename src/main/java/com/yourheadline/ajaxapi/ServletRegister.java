package com.yourheadline.ajaxapi;

import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.dao.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletRegister {
    @Autowired
    UserDAO userDAO;
    @Autowired
    AuthorDAO authorDAO;

    @PostMapping("/api/register")
    @ResponseBody
    public Map<String, String> doRegister(@RequestParam String userName, @RequestParam String passWord){
        return doRealRegister(userName,passWord, "normal");
    }

    @PostMapping("/api/register-author")
    @ResponseBody
    public Map<String, String> doRegisterAuthor(@RequestParam String userName, @RequestParam String passWord){
        Map<String, String> map =  doRealRegister(userName,passWord, "author");
        if (map.get("registerStatus").equals("Succeed")){
            AuthorEntity ae =new AuthorEntity();
            ae.setAuthorized(0);
            ae.setAuthorId(Integer.parseInt(map.get("userId")));
            authorDAO.save(ae);
        }
        return map;
    }



    private Map<String, String> doRealRegister(String userName, String passWord, String userType) {

        UserEntity u = new UserEntity();


        Map<String, String> map = new HashMap<>();
        String registerStatus = "";
        String userAvatarLink = "";


        int userId = 0;
        List<UserEntity> list = userDAO.findByUserName(userName);
        if (list.isEmpty()) {
            if (passWord.length() < 6) {
                registerStatus = "PasswordTooShort";
            } else {
                u.setUserName(userName);
                u.setPassword(passWord);
                u.setUserType(userType);
                userDAO.save(u);

                list = userDAO.findByUserName(userName);
                if (!list.isEmpty()) {

                    u = list.get(0);
                    userId = u.getUserId();
                    registerStatus = "Succeed";
                    userAvatarLink = u.getUserAvatarLink();
                } else {

                }
            }
        } else {
            registerStatus = "UsernameExist";
        }
        map.put("userId", String.valueOf(userId));
        map.put("registerStatus", registerStatus);
        map.put("userType", userType);
        map.put("userAvatarLink", userAvatarLink);

        return map;
    }


}
