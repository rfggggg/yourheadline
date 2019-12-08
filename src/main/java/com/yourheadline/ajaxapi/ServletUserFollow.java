package com.yourheadline.ajaxapi;

import com.yourheadline.dao.FollowDAO;
import com.yourheadline.entity.FollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ServletUserFollow {

    @Autowired
    FollowDAO followDAO;

    @GetMapping("/api/do-follow")
    @ResponseBody
    public Map<String, Object> doFollow(@RequestParam int userId, @RequestParam int authorId) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date date = new Date(System.currentTimeMillis());
        FollowEntity newFollow = new FollowEntity();
        newFollow.setAuthorId(authorId);
        newFollow.setUserId(userId);
        newFollow.setAddTime(date);
        followDAO.save(newFollow);
        map.put("status", "OK");

        return map;
    }


    @GetMapping("/api/cancel-follow")
    @ResponseBody
    public Map<String, Object> cancelFollow(@RequestParam int userId, @RequestParam int authorId){
        Map<String, Object> map = new HashMap<String, Object>();

        followDAO.deleteByUserIdAndAuthorId(userId, authorId);
        map.put("status", "OK");
        return map;
    }

    @GetMapping("/api/check-follow")
    @ResponseBody
    public Map<String, Object> ifFollow(@RequestParam int userId, @RequestParam int authorId){
        Map<String, Object> map = new HashMap<String, Object>();

        boolean isFollow;
        if(followDAO.findByUserIdAndAuthorId(userId, authorId).size()>0)
            isFollow=true;
        else
            isFollow=false;

        map.put("status", isFollow);
        return map;
    }
}
