package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserLikeArticleDAO;
import com.yourheadline.entity.UserLikeArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class ServletUserLike {

    @Autowired
    UserLikeArticleDAO userLikeArticleDAO;

    @GetMapping("/api/do-like-article")
    @ResponseBody
    public Map<String, Object> doLikeArticle(@RequestParam int articleId, @RequestParam int userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        Date date =new Date(System.currentTimeMillis());
        UserLikeArticleEntity newLike = new UserLikeArticleEntity();
        newLike.setArticleId(articleId);
        newLike.setUserId(userId);
        newLike.setAddTime(date);

        if(userLikeArticleDAO.findByUserIdAndArticleId(newLike.getUserId(),newLike.getArticleId()).size()>0) {
            map.put("status", "AlreadyLike");
        }
        else {
            userLikeArticleDAO.save(newLike);
            map.put("status", "OK");
        }

        return map;
    }

    @GetMapping("/api/cancel-like-article")
    @ResponseBody
    public Map<String, Object> cancelLikeArticle(@RequestParam int userId, @RequestParam int articleId) {
        Map<String, Object> map = new HashMap<String, Object>();

        userLikeArticleDAO.deleteByUserIdAndArticleId(userId, articleId);

        map.put("status", "OK");
        return map;
    }

    @GetMapping("/api/check-like-article")
    @ResponseBody
    public Map<String, Object> checkLikeArticle(@RequestParam int userId, @RequestParam int articleId){
        Map<String, Object> map = new HashMap<String, Object>();
        List<UserLikeArticleEntity> list = userLikeArticleDAO.findByUserIdAndArticleId(userId, articleId);
        Boolean status = true;
        if (list.isEmpty()){
            status=false;
        }
        map.put("status", status);
        return map;
    }
}
