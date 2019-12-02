package com.yourheadline.ajaxapi;


import com.yourheadline.dao.SearchDao;
import com.yourheadline.model.SearchViewInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletSearch {

    @Autowired
    SearchDao searchDao;

    @GetMapping("/search")
    @ResponseBody
    public Map<String, Object> getSearch(@RequestParam String keyword){

        Map<String, Object> map = new HashMap<String, Object>();

        List<SearchViewInfo> sdata = searchDao.findAllByKeyWord(keyword);

        if(sdata.isEmpty()){
            map.put("searchResult", null);
            return map;
        }
        else{
            map.put("searchResult", sdata);
            return map;
        }

    }
}
