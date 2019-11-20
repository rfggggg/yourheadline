package com.yourheadline.ajaxapi;


import com.yourheadline.dao.ModuleDAO;
import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.entity.ModuleEntity;
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
public class ServletModule {

    @Autowired
    ModuleDAO moduleDAO;
    @GetMapping("/module")
    @ResponseBody
    public Map<String, Object> getData(){

        Map<String, Object> map = new HashMap<String, Object>();

        List<ModuleEntity> mlist = moduleDAO.findAll();

        map.put("module_list", mlist);

        return map;

    }

}
