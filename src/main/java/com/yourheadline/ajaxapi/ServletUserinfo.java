package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletUserinfo {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/api/userinfo")
    @ResponseBody
    public Map<String, Object> finduserinfo(@RequestBody Map<String, String> inMap){
        Map<String, Object> map = new HashMap<>();

        UserEntity u = new UserEntity();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));

            List<UserEntity> userinfo = new ArrayList<>();
            userinfo = userDAO.findByUserId(userId);
            if (!userinfo.isEmpty()){
                u = userinfo.get(0);
            }
        }
        map.put("user_info",u);
        return map;
    }
}
