package com.yourheadline.ajaxapi;

import com.yourheadline.dao.ArticleDAO;
import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.yourheadline.entity.*;
import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ServletArticleHome {
//    @Autowired
//    ArticleDAO articleDAO;
    @Autowired
    ArticleInfoDAO articleInfoDAO;

    @GetMapping("/article/home")
    @ResponseBody
    public Map<String, Object> getData(){

        Map<String, Object> map = new HashMap<String, Object>();


        List<ArticleInfo> aiList = articleInfoDAO.findInfo();

//        老的用法，用@OneToMany和@ManyToOne的方法，注释掉不要了
//        List<ArticleEntity> aList = articleDAO.findAll();
//        List<ArticleInfo> aiList = new ArrayList<ArticleInfo>();
//
//        for (ArticleEntity a: aList){
//            ArticleInfo ai = new ArticleInfo();
//            ai.articleId = a.getArticleId();
//            ai.authorId = a.getAuthorId();
//            ai.editorId = a.getEditorId();
//            ai.moduleId = a.getModuleId();
//            ai.articleTitle = a.getArticleTitle();
//            ai.articleText = a.getArticleText();
//            ai.addTime = a.getAddTime();
//            ai.likeNum = a.getLikeNum();
//
//            ai.authorName = a.getAuthor().getAuthorName();
//            ai.editorName = "sb";
//
//            aiList.add(ai);
//        }
        map.put("article_list", aiList);

        return map;

    }
}
