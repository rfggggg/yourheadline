package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserFollowInfoDAO;
import com.yourheadline.model.UserFollowInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletUserFollowInfo {
    @Autowired
    UserFollowInfoDAO userFollowInfoDAO;
    @PostMapping("/api/userfollowinfo")
    @ResponseBody
    public Map<String, Object> finduserfollowinfo(@RequestBody Map<String, String> inMap) {

        Map<String, Object> map = new HashMap<>();
        List<UserFollowInfo> ufilist=new ArrayList<>();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));
            if(!userFollowInfoDAO.findByUserId(userId).isEmpty())
                ufilist=userFollowInfoDAO.findByUserId(userId);
        }
        map.put("user_info", ufilist);
        return map;
    }
}
