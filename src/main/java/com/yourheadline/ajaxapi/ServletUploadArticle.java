package com.yourheadline.ajaxapi;


import com.yourheadline.dao.ArticleUncheckedDAO;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.entity.ArticleUncheckedEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class ServletUploadArticle {
    @Autowired
    ArticleUncheckedDAO articleUncheckedDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    Validation validation;

    @PostMapping("/new-article")
    @ResponseBody
    public Map<String, Object> uploadNewArticle(@RequestParam Integer authorId,
                                             @RequestParam String authorName,
                                             @RequestParam String password,

                                             @RequestParam String articleTitle,
                                             @RequestParam String articleIntro,
                                             @RequestParam String articleText,

                                             @RequestParam Integer moduleId
                                             )
    {
        Date applyDate = new Date(Calendar.getInstance().getTimeInMillis());

        Map<String, Object> map = new HashMap<>();

        String status = "";

        if (validation.checkAuthor(authorId, authorName, password)){
                ArticleUncheckedEntity a = articleUncheckedDAO.save(
                        new ArticleUncheckedEntity(
                                authorId,moduleId ,articleTitle,articleIntro,articleText,applyDate
                        )
                );
                status = "Succeed";
        }
        else{
            status = "FailCheckAuthor";
        }


        //打印接收的参数
//        for (Map.Entry<String, String> entry : inMap.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }

        map.put("status", status);
        return map;
    }




    @PostMapping("/edit-article")
    @ResponseBody
    public Map<String, Object> editArticle(@RequestParam Integer articleId,

                                             @RequestParam Integer authorId,
                                             @RequestParam String authorName,
                                             @RequestParam String password,

                                             @RequestParam String articleTitle,
                                             @RequestParam String articleIntro,
                                             @RequestParam String articleText,

                                             @RequestParam Integer moduleId
    )
    {
        Date applyDate = new Date(Calendar.getInstance().getTimeInMillis());

        Map<String, Object> map = new HashMap<>();

        String status = "";

        if (validation.checkAuthor(authorName,password)){
            if (articleId==0){
                ArticleUncheckedEntity a = articleUncheckedDAO.save(
                        new ArticleUncheckedEntity(
                                authorId,moduleId ,articleTitle,articleIntro,articleText,applyDate
                        )
                );
                articleId = a.getId();
                status = "Succeed";
            }
            else {
                ArticleUncheckedEntity a = articleUncheckedDAO.save(
                        new ArticleUncheckedEntity(
                                articleId, authorId,moduleId ,articleTitle,articleIntro,articleText,applyDate
                        )
                );
                status = "AuthorNotChecked";
            }
        }
        else{
            status = "FailCheckAuthor";
            articleId = 0;
        }


        //打印接收的参数
//        for (Map.Entry<String, String> entry : inMap.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }

        map.put("status", status);
        map.put("articleId", articleId);
        return map;
    }
}
