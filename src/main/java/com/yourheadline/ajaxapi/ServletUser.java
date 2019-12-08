package com.yourheadline.ajaxapi;


import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.dao.UserPublicInfoDAO;
import com.yourheadline.dao.ViewedDAO;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.entity.ViewedEntity;
import com.yourheadline.model.ArticleInfoEntity;
import com.yourheadline.model.UserPublicInfoEntity;
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
public class ServletUser {
    @Autowired
    UserDAO userDAO;
    @Autowired
    ViewedDAO viewedDAO;
    @Autowired
    ArticleInfoDAO articleInfoDAO;
    @Autowired
    Validation validation;
    @Autowired
    UserPublicInfoDAO userPublicInfoDAO;


    @GetMapping("/api/user/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        int userId = 0;
        String status = "Fail";
        String userType = "";
        String userAvatarLink = "";

        List<UserEntity> list = userDAO.findByUserName(username);
        if (list.isEmpty()){
            status = "UserNotExist";
        }
        else if (!list.get(0).getPassword().equals(password)){
            status = "PasswordError";
        }
        //用户名与密码正确
        else {
            status = "OK";
            userType = list.get(0).getUserType();
            userAvatarLink = list.get(0).getUserAvatarLink();
            userId = list.get(0).getUserId();
        }

        map.put("userId", userId);

        map.put("status", status);
        map.put("userType", userType);
        map.put("userAvatarLink", userAvatarLink);

        return map;

    }

    @GetMapping("/api/user/register")
    @ResponseBody
    public Map<String, Object> register(@RequestParam String username, @RequestParam String password) {
        UserEntity u = new UserEntity();

        Map<String, Object> map = new HashMap<>();
        String registerStatus = "";
        String userAvatarLink = "";


        int userId = 0;
        List<UserEntity> list = userDAO.findByUserName(username);
        if (list.isEmpty()) {
            if (password.length() < 6) {
                registerStatus = "PasswordTooShort";
            } else {
                u.setUserName(username);
                u.setPassword(password);
                u.setUserType("normal");
                userDAO.save(u);

                list = userDAO.findByUserName(username);
                if (!list.isEmpty()) {

                    u = list.get(0);
                    userId = u.getUserId();
                    registerStatus = "OK";
                    userAvatarLink = u.getUserAvatarLink();
                } else {

                }
            }
        } else {
            registerStatus = "UsernameExist";
        }
        map.put("userId", String.valueOf(userId));
        map.put("status", registerStatus);
        map.put("userType", "normal");
        map.put("userAvatarLink", userAvatarLink);

        return map;
    }

    @GetMapping("/api/user/history")
    @ResponseBody
    public Map<String, Object> getHistoryArticle(@RequestParam int userId, @RequestParam String username, @RequestParam String password, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (validation.checkUser(userId, username, password)!=null) {
            PageRequest pr = PageRequest.of(startId / 10, 10);
            List<ArticleInfoEntity> aiList = articleInfoDAO.selectHistoryByUserId(userId, pr).getContent();
            if (aiList.isEmpty()){
                map.put("status", "Empty");
            }
            else {
                map.put("status", "OK");
                map.put("articleList", aiList);
            }
        }
        else{
            map.put("status", "FailCheckUser");
        }
        return map;
    }


    @GetMapping("/api/user/collect")
    @ResponseBody
    public Map<String, Object> getCollectionArticle(@RequestParam int userId, @RequestParam String username, @RequestParam String password, @RequestParam int startId){

        Map<String, Object> map = new HashMap<String, Object>();
        if(validation.checkUser(userId, username, password)!=null) {
            PageRequest pr = PageRequest.of(startId / 10, 10);
            List<ArticleInfoEntity> aiList = articleInfoDAO.selectCollectionByUserId(userId, pr).getContent();
            if (!aiList.isEmpty()){
                map.put("articleList", aiList);
                map.put("status", "OK");
            }
            else{
                map.put("status", "Empty");
            }
        }
        else {
            map.put("status", "FailCheckUser");
        }
        return map;
    }


    @GetMapping("/api/user/following-author")
    @ResponseBody
    public Map<String, Object> getFollowingAuthor(@RequestParam int userId, @RequestParam String username, @RequestParam String password, @RequestParam int startId){
        Map<String, Object> map = new HashMap<>();

        if(validation.checkUser(userId, username, password)!=null) {
            Pageable pr = PageRequest.of(startId / 10, 10);
            List<UserPublicInfoEntity> ufList = userPublicInfoDAO.selectFollowingAuthor(userId, pr).getContent();
            if (ufList.isEmpty()){
                map.put("status", "Empty");
            }
            else{
                map.put("userInfo", ufList);
                map.put("status", "OK");
            }
        }
        else {
            map.put("status", "FailCheckUser");
        }
        return map;
    }


    @GetMapping("/api/user/feed")
    @ResponseBody
    public Map<String, Object> getFeedArticle(@RequestParam int userId, @RequestParam String username, @RequestParam String password, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (validation.checkUser(userId, username, password)!=null) {
            PageRequest pr = PageRequest.of(startId / 10, 10);
            List<ArticleInfoEntity> aiList = articleInfoDAO.selectFeedByUserId(userId, pr).getContent();
            if (aiList.isEmpty()){
                map.put("status", "Empty");
            }
            else {
                map.put("status", "OK");
                map.put("articleList", aiList);
            }
        }
        else{
            map.put("status", "FailCheckUser");
        }
        return map;
    }

    @GetMapping("/api/user/info")
    @ResponseBody
    public Map<String, Object> getUserInfo(String username, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();

        if (validation.checkUser(username, password)!=null) {
            List<UserEntity> userInfo = userDAO.findByUserName(username);
            UserEntity u = userInfo.get(0);
            map.put("userInfo",u);
            map.put("status", "OK");
        }
        else{
            map.put("status", "FailCheckUser");
        }
        return map;
    }

    @PostMapping("/api/user/update-info")
    @ResponseBody
    public Map<String, Object> updateUserInfo(@RequestBody Map<String, String> inMap) {
        Map<String, Object> map = new HashMap<>();

        UserEntity u = new UserEntity();
        if (inMap.containsKey("userId")) {
            int userId = Integer.parseInt(inMap.get("userId"));

            List<UserEntity> userinfo = new ArrayList<>();
            userinfo = userDAO.findByUserId(userId);
            if (!userinfo.isEmpty()){
                u = userinfo.get(0);
            }
            if (inMap.containsKey("userName")) {
                u.setUserName(inMap.get("userName"));
            }
            if (inMap.containsKey("birthDate")) {
                String date=inMap.get("birthDate");
                int year=Integer.parseInt(date.substring(0,4));
                int month=Integer.parseInt(date.substring(5,7));
                int day=Integer.parseInt(date.substring(8,10));
                Calendar newDay=new GregorianCalendar(year, month-1, day);
                Date newBirthday=new Date(newDay.getTimeInMillis());
                u.setBirthDate(newBirthday);
            }
            if(inMap.containsKey("gender")){
                u.setGender(inMap.get("gender"));
            }
            if (inMap.containsKey("email")) {
                u.setEmail(inMap.get("email"));
            }
            if(inMap.containsKey("mobilePhone")) {
                u.setMobilePhone(inMap.get("mobilePhone"));
            }
            userDAO.save(u);
        }
        map.put("userInfo", u);
        return map;
    }

    @PostMapping("/api/user/update-avatar")
    @ResponseBody
    public Map<String, Object> updateAvatar(@RequestParam String username, @RequestParam String password, @RequestParam String userAvatarLink) {
        Map<String, Object> map = new HashMap<>();

        if (validation.checkUser(username, password)!=null) {
            List<UserEntity> userInfo = userDAO.findByUserName(username);

            UserEntity u = userInfo.get(0);
            u.setUserAvatarLink(userAvatarLink);

            userDAO.save(u);

            map.put("userInfo",u);
            map.put("status", "OK");
        }
        else{
            map.put("status", "FailCheckUser");
        }
        return map;
    }

    @GetMapping("/api/article/add-view")
    @ResponseBody
    public Map<String, Object> addView(@RequestParam int userId, @RequestParam int articleId){
        Date addDate = new Date(Calendar.getInstance().getTimeInMillis());

        String status = "Fail";
        Map<String, Object> map = new HashMap<>();

        ViewedEntity v = new ViewedEntity();
        v.setAddTime(addDate);
        v.setArticleId(articleId);
        v.setUserId(userId);
        v = viewedDAO.save(v);

        if (v!=null) {
            status = "Succeed";
        }

        map.put("status", status);
        return map;
    }


}
