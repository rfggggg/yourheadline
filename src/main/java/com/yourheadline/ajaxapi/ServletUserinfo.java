package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String, Object> finduserinfo(@RequestParam Map<String, String> inMap){
        Map<String, Object> map = new HashMap<>();

        List<UserEntity> userinfo = new ArrayList<>();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));
            userinfo = userDAO.findByUserId(userId);
        }
        map.put("user_info",userinfo);
        return map;
    }
}
