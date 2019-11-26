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

    @GetMapping("/plusLikeNumOfArticle")
    @ResponseBody
    public Map<String, Object> plusLikeNumOfArticle(@RequestParam int userId,int articleId ) {
        Map<String, Object> map = new HashMap<String, Object>();


     //   UserLikeArticleEntity newLike = new UserLikeArticleEntity();
       // userLikeArticleDAO.save(newLike);
        //map.put("userLikeArticle", newLike);

        return map;
    }
}
