package com.yourheadline.ajaxapi;

import com.yourheadline.entity.UserEntity;
import com.yourheadline.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServletRegister {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/api/register")
    @ResponseBody
    public String doRegister(@RequestParam String userName, @RequestParam String passWord){
        UserEntity u = new UserEntity();

        u.setUserName(userName);
        u.setPassword(passWord);
        userDAO.save(u);
        return "ok";
    }
}
