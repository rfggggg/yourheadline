package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class ServletUpdateUser {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/updateUser")
    @ResponseBody
    public Map<String, Object> updateuserinfo(@RequestBody Map<String, String> inMap) throws ParseException {
        Map<String, Object> map = new HashMap<>();

        UserEntity u = new UserEntity();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));

            List<UserEntity> userinfo = new ArrayList<>();
            userinfo = userDAO.findByUserId(userId);
            if (!userinfo.isEmpty()){
                u = userinfo.get(0);
            }
            if (inMap.containsKey("userName")) {
                u.setUserName(inMap.get("userName"));
            }
//            if (inMap.containsKey("birthDate")) {
//                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//                u.setBirthDate((Date) sdf2.parse(inMap.get("birthDate")));
//            }
            if (inMap.containsKey("email")) {
                u.setEmail(inMap.get("email"));
            }
            if(inMap.containsKey("mobilePhone")) {
                u.setMobilePhone(inMap.get("mobilePhone"));
            }
            userDAO.save(u);
        }
        map.put("user_info", u);
        return map;
    }
}
