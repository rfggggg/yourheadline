package com.yourheadline.ajaxapi;

import com.yourheadline.dao.FollowDAO;
import com.yourheadline.entity.FollowEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletFollow {
    @Autowired
    FollowDAO followDAO;

    @PostMapping("/addNewFollow")
    @ResponseBody
    public Map<String, Object> addNewFollow(@RequestBody Map<String, String> data) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date date = new Date(System.currentTimeMillis());
        FollowEntity newFollow = new FollowEntity();
        newFollow.setAuthorId(Integer.parseInt(data.get("authorId")));
        newFollow.setUserId(Integer.parseInt(data.get("userId")));
        newFollow.setAddTime(date);
        followDAO.save(newFollow);
        map.put("follow", newFollow);

        return map;
    }


    @PostMapping("/deleteFollow")
    @ResponseBody
    public Map<String, Object> deleteFollow(@RequestBody Map<String,String> data){
        Map<String, Object> map = new HashMap<String, Object>();

        followDAO.deleteByUserIdAndAuthorId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("authorId")));
        return map;
    }

    @PostMapping("/haveFollow")
    @ResponseBody
    public Map<String, Object> haveFollow(@RequestBody Map<String,String> data){
        Map<String, Object> map = new HashMap<String, Object>();

        boolean isFollow;
        if(followDAO.findByUserIdAndAuthorId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("authorId"))).size()>0)
            isFollow=true;
        else
            isFollow=false;

        map.put("haveFollow", isFollow);
        return map;
    }
}