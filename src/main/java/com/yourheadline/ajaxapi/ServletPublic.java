package com.yourheadline.ajaxapi;

import com.yourheadline.dao.*;
import com.yourheadline.entity.*;
import com.yourheadline.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ServletPublic {

    @Autowired
    ArticleInfoDAO articleInfoDAO;
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    ViewedDAO viewedDAO;
    @Autowired
    CommentInfoDAO commentInfoDAO;
    @Autowired
    ModuleDAO moduleDAO;
    @Autowired
    UserPublicInfoDAO userPublicInfoDAO;

    @GetMapping("/api/article/home")
    @ResponseBody
    public Map<String, Object> getFeedArticle(@RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        PageRequest pr = PageRequest.of(startId/10, 10);
        List<ArticleInfoEntity> aiList = articleInfoDAO.findAll(pr).getContent();

        if (aiList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("articleList", aiList);
        }
        return map;
    }




    @GetMapping("/api/article/search")
    @ResponseBody
    public Map<String, Object> getSearchArticle(@RequestParam String searchKey,@RequestParam  int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        PageRequest pr = PageRequest.of(startId/10, 10);
        List<ArticleInfoEntity> aiList = articleInfoDAO.selectArticleInfoByKeyWord(searchKey, pr).getContent();
        if (aiList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("articleList", aiList);
        }
        return map;
    }

    @GetMapping("/api/module")
    @ResponseBody
    public Map<String, Object> getAllModule() {
        Map<String, Object> map = new HashMap<String, Object>();

        List<ModuleEntity> mList = moduleDAO.findAll();

        if (mList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("moduleList", mList);
        }
        return map;
    }

    @GetMapping("/api/article/module")
    @ResponseBody
    public Map<String, Object> getModuleArticle(@RequestParam int moduleId, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        PageRequest pr = PageRequest.of(startId/10, 10);
        List<ArticleInfoEntity> aiList = articleInfoDAO.findByModuleId(moduleId, pr).getContent();

        if (aiList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("articleList", aiList);
        }
        return map;
    }

    @GetMapping("/api/article/detail")
    @ResponseBody
    public Map<String, Object> getArticleDetail(@RequestParam int articleId) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleEntity> aList = articleDAO.findByArticleId(articleId);

        if (aList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("article", aList.get(0));
        }
        return map;
    }

    @GetMapping("/api/article/comment")
    @ResponseBody
    public Map<String, Object> getComment(@RequestParam int articleId, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        PageRequest pr = PageRequest.of(startId/10, 10);
        List<CommentInfoEntity> ciList = commentInfoDAO.findByArticleId(articleId, pr).getContent();

        if (ciList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("commentList", ciList);
        }
        return map;
    }

    @GetMapping("/api/article/author-all")
    @ResponseBody
    public Map<String, Object> getAuthorAllArticle(@RequestParam int authorId, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        PageRequest pr = PageRequest.of(startId/10, 10);
        List<ArticleInfoEntity> aiList=articleInfoDAO.findByAuthorId(authorId, pr).getContent();

        if (aiList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("articleList", aiList);
        }
        return map;
    }

    @GetMapping("/api/user/public-info")
    @ResponseBody
    public Map<String, Object> getUserPublicInfo(@RequestParam int userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<UserPublicInfoEntity> uList = userPublicInfoDAO.findByUserId(userId);

        if (uList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("userInfo", uList.get(0));
        }
        return map;
    }


    @GetMapping("/api/article/info")
    @ResponseBody
    public Map<String, Object> getArticleInfo(@RequestParam int articleId) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleInfoEntity> aiList = articleInfoDAO.findByArticleId(articleId);

        if (aiList.isEmpty()){
            map.put("status", "Empty");
        }
        else {
            map.put("status", "OK");
            map.put("articleList", aiList);
        }
        return map;
    }

}
