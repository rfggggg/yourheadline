package com.yourheadline.ajaxapi;


import com.yourheadline.dao.CollectDAO;
import com.yourheadline.entity.CollectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
}
