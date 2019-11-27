package com.yourheadline.ajaxapi;

import com.yourheadline.dao.UserLikeArticleDAO;
import com.yourheadline.entity.UserLikeArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletUserLikeArticle {
    @Autowired
    UserLikeArticleDAO userLikeArticleDAO;

    @PostMapping("/plusLikeNumOfArticle")
    @ResponseBody
    public Map<String, Object> plusLikeNumOfArticle(@RequestBody Map<String,String>data) {
        Map<String, Object> map = new HashMap<String, Object>();


        UserLikeArticleEntity newLike = new UserLikeArticleEntity();
        newLike.setArticleId(Integer.parseInt(data.get("articleId")));
        newLike.setUserId(Integer.parseInt(data.get("userId")));
        userLikeArticleDAO.save(newLike);
        map.put("userLikeArticle", newLike);

        return map;
    }

    @PostMapping("/minusLikeNumOfArticle")
    @ResponseBody
    public Map<String, Object> minusLikeNumOfArticle(@RequestBody Map<String,String>data) {
        Map<String, Object> map = new HashMap<String, Object>();

        userLikeArticleDAO.deleteByUserIdAndArticleId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("articleId")));

        return map;
    }
}
