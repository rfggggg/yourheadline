package com.yourheadline.ajaxapi;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletLogin {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/api/login")
    @ResponseBody
    public Map<String, Object> doLogin(@RequestParam String userName, @RequestParam String passWord){

        Map<String, Object> map = new HashMap<>();
<<<<<<< HEAD
=======
        int userId = 0;
>>>>>>> xy
        String loginStatus = "";
        String userType = "";
        String userAvatarLink = "";

        List<UserEntity> list = userDAO.findByUserName(userName);
        if (list.isEmpty()){
            loginStatus = "UserNotExist";
        }
        else if (!list.get(0).getPassword().equals(passWord)){
            loginStatus = "PasswordError";
        }
        //用户名与密码正确
        else {
            loginStatus = "Succeed";
            userType = list.get(0).getUserType();
            userAvatarLink = list.get(0).getUserAvatarLink();
<<<<<<< HEAD
        }

=======
            userId = list.get(0).getUserId();
        }

        map.put("userId", userId);
>>>>>>> xy
        map.put("loginStatus", loginStatus);
        map.put("userType", userType);
        map.put("userAvatarLink", userAvatarLink);

        return map;

    }
}
