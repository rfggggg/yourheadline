package com.yourheadline.ajaxapi;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServletLogin {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/api/login")
    @ResponseBody
    public String doLogin(@RequestParam String userName, @RequestParam String passWord){

        UserEntity u = userDAO.findByUserName(userName).get(0);
        if (u.getPassword().equals(passWord)){
            return "ok";
        }
        else {
            return  "fail";
        }

    }
}
