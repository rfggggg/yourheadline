package com.yourheadline.ajaxapi;


import com.yourheadline.dao.ArticleDAO;
import com.yourheadline.dao.ArticleUncheckedDAO;
import com.yourheadline.dao.AuthorDAO;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.entity.ArticleUncheckedEntity;
import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class ServletUploadArticle {
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    Validation validation;
    @Autowired
    AuthorDAO authorDAO;

    @PostMapping("/new-article")
    @ResponseBody
    public Map<String, Object> uploadNewArticle(@RequestParam Integer authorId,
                                             @RequestParam String authorName,
                                             @RequestParam String password,

                                             @RequestParam String articleTitle,
                                             @RequestParam String articleText,

                                             @RequestParam Integer moduleId
                                             )
    {
        Date addDate = new Date(Calendar.getInstance().getTimeInMillis());

        Map<String, Object> map = new HashMap<>();

        String status = "FailCheckAuthor";

        if (validation.checkAuthor(authorId, authorName, password)){
            List<AuthorEntity> auList = authorDAO.findByAuthorId(authorId);
            if (!auList.isEmpty()){
                if (auList.get(0).getAuthorized()==1){
                    ArticleEntity a = new ArticleEntity();
                    a.setAuthorId(authorId);
                    a.setArticleTitle(articleTitle);
                    a.setArticleText(articleText);
                    a.setAddTime(addDate);
                    a.setModuleId(moduleId);

                    a.setCoverLink(getFirstImage(articleText));

                    a = articleDAO.save(a);
                    if (a!=null) {
                        status = "Succeed";
                    }
                    else{
                        status = "DatabaseInnerError";
                    }
                }
            }

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
        Date curDate = new Date(Calendar.getInstance().getTimeInMillis());

        Map<String, Object> map = new HashMap<>();

        String status = "";

        List<ArticleEntity> aList = articleDAO.findByArticleId(articleId);
        ArticleEntity ae;
        if (!aList.isEmpty()){
            ae = aList.get(0);
        }
        else{
            return null;
        }
        if (validation.checkAuthor(authorName,password) && ae.getAuthorId().equals(authorId)){
            ae.setArticleTitle(articleTitle);
            ae.setArticleText(articleText);
            ae.setCoverLink(getFirstImage(articleText));
            articleDAO.save(ae);
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

    private String getFirstImage(String articleText)
    {
        String firstImageBeginTag = "<img src=\"";
        char firstImageEndTag = '\"';
        int firstImageBegin = articleText.indexOf(firstImageBeginTag);
        if (firstImageBegin!=-1) {
            firstImageBegin += firstImageBeginTag.length();
            int firstImageLength = articleText.substring(firstImageBegin).indexOf(firstImageEndTag);
//                firstImageLength += 1; //!!!!!!!!!!!!
            return articleText.substring(firstImageBegin, firstImageBegin + firstImageLength);
        }
        return "";
    }
}
