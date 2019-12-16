package com.yourheadline.ajaxapi;

import com.yourheadline.dao.*;
import com.yourheadline.entity.*;
import com.yourheadline.model.ArticleInfoEntity;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.Date;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletAuthor {

    @Autowired
    UserDAO userDAO;
    @Autowired
    AuthorDAO authorDAO;
    @Autowired
    Validation validation;
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    ArticleUncheckedDAO articleUncheckedDAO;

    @GetMapping("/api/author/register")
    @ResponseBody
    public Map<String, String> doRegisterAuthor(@RequestParam String username, @RequestParam String password){
        UserEntity u = new UserEntity();

        Map<String, String> map = new HashMap<>();
        String registerStatus = "";
        String userAvatarLink = "";

        int userId = 0;
        List<UserEntity> list = userDAO.findByUserName(username);
        if (list.isEmpty()) {
            if (password.length() < 6) {
                registerStatus = "PasswordTooShort";
            }
            else {
                u.setUserName(username);
                u.setPassword(password);
                u.setUserType("author");
                u = userDAO.save(u);

                userId = u.getUserId();
                registerStatus = "Succeed";
                userAvatarLink = u.getUserAvatarLink();

                AuthorEntity ae =new AuthorEntity();
                ae.setAuthorized(0);
                ae.setAuthorId(userId);
                authorDAO.save(ae);
            }
        }
        else {
            registerStatus = "UsernameExist";
        }
        map.put("userId", String.valueOf(userId));
        map.put("registerStatus", registerStatus);
        map.put("userType", "author");
        map.put("userAvatarLink", userAvatarLink);


        return map;
    }



    @PostMapping("/api/upload-confirm-file")
    @ResponseBody
    public Map<String, String> uploadConfirmFile(Integer authorId,
                                                   String authorName,
                                                   String password,
                                                   String idCardBack,
                                                   String idCardFront,
                                                   String applyText)
    {
        String status = "Fail";
        Map<String, String> map = new HashMap<>();

        if (null == validation.checkAuthor(authorId, authorName, password)) {
            status = "FailCheckAuthor";
        }
        else {
            List<AuthorEntity> auList = authorDAO.findByAuthorId(authorId);

            AuthorEntity aue;
            if (auList.isEmpty()) {

            } else {
                aue = auList.get(0);

                aue.setIdCardBack(idCardBack);
                aue.setIdCardFront(idCardFront);
                aue.setApplyText(applyText);
                aue.setApplyTime(new Date(Calendar.getInstance().getTimeInMillis()));
                authorDAO.save(aue);
                status = "OK";
            }
        }


        map.put("status", status);
        return map;
    }




    @GetMapping("/api/check-if-authorize")
    @ResponseBody
    public Map<String, Object> ifAuthorized(@RequestParam int authorId){
        Map<String, Object> map = new HashMap<>();
        boolean status = false;
        List<AuthorEntity> list = authorDAO.findByAuthorId(authorId);
        if (!list.isEmpty()){
            AuthorEntity ae =list.get(0);
            if (ae.getAuthorized()==1){
                status = true;
            }
        }
        map.put("status", status);
        return map;
    }




    @PostMapping("/api/new-article")
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

        if (validation.checkAuthor(authorId, authorName, password)!=null){
            List<AuthorEntity> auList = authorDAO.findByAuthorId(authorId);
            if (!auList.isEmpty()){
                if (auList.get(0).getAuthorized()==1){
                    ArticleUncheckedEntity a = new ArticleUncheckedEntity();
                    a.setAuthorId(authorId);
                    a.setArticleTitle(articleTitle);
                    a.setArticleText(articleText);
                    a.setAddTime(addDate);
                    a.setModuleId(moduleId);
                    a.setCoverLink(getFirstImage(articleText));

                    a = articleUncheckedDAO.save(a);
                    if (a!=null) {
                        status = "OK";
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


    @PostMapping("/api/edit-article")
    @ResponseBody
    public Map<String, Object> editArticle(@RequestParam Integer articleId,

                                           @RequestParam Integer authorId,
                                           @RequestParam String authorName,
                                           @RequestParam String password,

                                           @RequestParam String articleTitle,
                                           @RequestParam String articleText,

                                           @RequestParam Integer moduleId
    )
    {
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
        if (validation.checkAuthorizeAuthor(authorName,password) != null && ae.getAuthorId().equals(authorId)){
            ae.setArticleTitle(articleTitle);
            ae.setArticleText(articleText);
            ae.setCoverLink(getFirstImage(articleText));
            ae.setModuleId(moduleId);
            articleDAO.save(ae);
            status = "OK";
        }
        else{
            status = "FailCheckAuthor";
        }

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
