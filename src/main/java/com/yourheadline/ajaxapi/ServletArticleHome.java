package com.yourheadline.ajaxapi;

import com.yourheadline.dao.ArticleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.yourheadline.entity.*;
import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ServletArticleHome {

    @Autowired
    ArticleDAO articleDAO;
    @GetMapping("/article/home")
    @ResponseBody
    public Map<String, Object> getData(){

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleEntity> alist = articleDAO.findAll();

        map.put("article_list", alist);

        return map;

    }
}
