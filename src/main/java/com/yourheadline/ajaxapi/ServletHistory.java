package com.yourheadline.ajaxapi;


import com.yourheadline.dao.HistoryDAO;
import com.yourheadline.entity.ViewedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletHistory {

    @Autowired
    HistoryDAO historyDAO;

    @GetMapping("/history")
    @ResponseBody
    public Map<String, Object> gethistorydata(){
        Map<String, Object> map = new HashMap<String, Object>();

        List<ViewedEntity> hlist = historyDAO.findAll();

        map.put("history_list", hlist);

        return map;
    }
}
