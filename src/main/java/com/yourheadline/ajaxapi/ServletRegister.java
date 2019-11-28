package com.yourheadline.ajaxapi;

import com.yourheadline.entity.UserEntity;
import com.yourheadline.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletRegister {
    @Autowired
    UserDAO userDAO;

    private enum UserType {
        normal, unchecked_author
    }

    @PostMapping("/api/register")
    @ResponseBody
    public Map<String, Object> doRegister(@RequestParam String userName, @RequestParam String passWord){

        return doRealRegister(userName,passWord, UserType.normal);
    }

    @PostMapping("/api/register-author")
    @ResponseBody
    public Map<String, Object> doRegisterAuthor(@RequestParam String userName, @RequestParam String passWord){

        return doRealRegister(userName,passWord, UserType.unchecked_author);
    }



    private Map<String, Object> doRealRegister(String userName, String passWord, UserType type) {

        UserEntity u = new UserEntity();


        Map<String, Object> map = new HashMap<>();
        String registerStatus = "";
        String userType = "";
        String userAvatarLink = "";

        if (type == UserType.normal){
            userType = "normal";
        }
        if (type == UserType.unchecked_author){
            userType = "unchecked_author";
        }



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
        map.put("userId", userId);
        map.put("registerStatus", registerStatus);
        map.put("userType", userType);
        map.put("userAvatarLink", userAvatarLink);

        return map;
    }

<<<<<<< HEAD

=======
>>>>>>> xy
}
