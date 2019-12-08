package com.yourheadline.ajaxapi;


import com.yourheadline.dao.CollectDAO;
import com.yourheadline.entity.CollectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
public class ServletUserCollect {

    @Autowired
    CollectDAO collectDAO;


    @GetMapping("/api/do-collect")
    @ResponseBody
    public Map<String, Object> doCollect(@RequestParam int articleId, @RequestParam int userId){
        Map<String, Object> map = new HashMap<String, Object>();
        CollectEntity newCollect=new CollectEntity();
        Date date=new Date(System.currentTimeMillis());
        newCollect.setArticleId(articleId);
        newCollect.setUserId(userId);
        newCollect.setAddTime(date);
        if(collectDAO.findByUserIdAndArticleId(newCollect.getUserId(),newCollect.getArticleId()).size()>0)
            ;
        else
            collectDAO.save(newCollect);

        map.put("status", "OK");

        return map;
    }

    @GetMapping("/api/delete-collect")
    @ResponseBody
    public Map<String, Object> deleteCollect(@RequestParam int articleId, @RequestParam int userId){
        Map<String, Object> map = new HashMap<String, Object>();

        collectDAO.deleteByUserIdAndArticleId(userId, articleId);
        map.put("status", "OK");
        return map;
    }

    @GetMapping("/api/check-collect")
    @ResponseBody
    public Map<String, Object> checkCollect(@RequestParam int articleId, @RequestParam int userId){
        Map<String, Object> map = new HashMap<String, Object>();

        boolean isCollect;
        if(collectDAO.findByUserIdAndArticleId(userId, articleId).size()>0)
            isCollect=true;
        else
            isCollect=false;

        map.put("status", isCollect);
        return map;
    }
}