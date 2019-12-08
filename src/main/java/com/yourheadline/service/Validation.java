package com.yourheadline.service;

import com.yourheadline.dao.AuthorDAO;
import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class Validation {


    @Autowired
    private UserDAO userDAO;
    @Autowired
    private AuthorDAO authorDAO;

    private static Validation instance;
    @PostConstruct
    public void init()
    {
        instance = this;
        instance.userDAO = this.userDAO;
    }


    public UserEntity checkUser(String username, String password)
    {
        List<UserEntity> list = userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    public UserEntity checkUser(int userId, String username, String password)
    {
        UserEntity u =checkUser(username, password);
        if (u!=null){
            if (u.getUserId() == userId){
                return u;
            }
        }
        return null;
    }

    public UserEntity checkAuthor(String username, String password)
    {
        List<UserEntity> list = userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("author")){
                return u;
            }
        }
        return null;
    }

    public UserEntity checkAuthor(int authorId, String authorName, String password) {
        List<UserEntity> list = userDAO.findByUserName(authorName);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserId() == authorId && u.getUserType().equals("author")){
                return u;
            }
        }
        return null;
    }
    public UserEntity checkAuthorizeAuthor(String authorName, String password){
        List<UserEntity> list = userDAO.findByUserName(authorName);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("author")){
                List<AuthorEntity> list1 = authorDAO.findByAuthorId(u.getUserId());
                if (!list1.isEmpty()){
                    AuthorEntity ae = list1.get(0);
                    if (ae.getAuthorized()==1){
                        return u;
                    }
                }
            }
        }
        return null;
    }

    public UserEntity checkAuthorizeAuthor(int authorId, String authorName, String password){
        List<UserEntity> list = userDAO.findByUserName(authorName);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) &&  u.getUserId() == authorId && u.getUserType().equals("author")){
                List<AuthorEntity> list1 = authorDAO.findByAuthorId(authorId);
                if (!list1.isEmpty()){
                    AuthorEntity ae = list1.get(0);
                    if (ae.getAuthorized()==1){
                        return u;
                    }
                }
            }
        }
        return null;
    }

    public UserEntity checkEditor(String username, String password)
    {
        List<UserEntity> list = userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("editor")){
                return u;
            }
        }
        return null;
    }
    public UserEntity checkEditor(int editorId, String username, String password)
    {
        List<UserEntity> list = userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("editor") && u.getUserId()==editorId){
                return u;
            }
        }
        return null;
    }


}
