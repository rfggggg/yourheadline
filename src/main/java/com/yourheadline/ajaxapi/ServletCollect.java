package com.yourheadline.ajaxapi;


import com.yourheadline.dao.CollectDAO;
import com.yourheadline.entity.CollectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ServletCollect {

    @Autowired
    CollectDAO collectDAO;
    @GetMapping("/collect")
    @ResponseBody
    public Map<String, Object> getcollectdata(){
        Map<String, Object> map = new HashMap<String, Object>();

        List<CollectEntity> clist = collectDAO.findAll();

        map.put("collect_list", clist);

        return map;
    }

    @PostMapping("/addNewCollect")
    @ResponseBody
    public Map<String, Object> addNewCollect(@RequestBody Map<String,String> data){
        Map<String, Object> map = new HashMap<String, Object>();
        CollectEntity newCollect=new CollectEntity();
        Date date=new Date(System.currentTimeMillis());
        newCollect.setArticleId(Integer.parseInt(data.get("articleId")));
        newCollect.setUserId(Integer.parseInt(data.get("userId")));
        newCollect.setAddTime(date);
        if(collectDAO.findByUserIdAndArticleId(newCollect.getUserId(),newCollect.getArticleId()).size()>0)
            ;
        else
        collectDAO.save(newCollect);

        map.put("newCollect", newCollect);

        return map;
    }

    @PostMapping("/deleteCollect")
    @ResponseBody
    public Map<String, Object> deleteCollect(@RequestBody Map<String,String> data){
        Map<String, Object> map = new HashMap<String, Object>();

        collectDAO.deleteByUserIdAndArticleId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("articleId")));
        return map;
    }

    @PostMapping("/haveCollect")
    @ResponseBody
    public Map<String, Object> haveCollect(@RequestBody Map<String,String> data){
        Map<String, Object> map = new HashMap<String, Object>();

        boolean isCollect;
        if(collectDAO.findByUserIdAndArticleId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("articleId"))).size()>0)
            isCollect=true;
        else
            isCollect=false;

        map.put("haveCollect", isCollect);
        return map;
    }
}