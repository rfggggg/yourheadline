package com.yourheadline.service;

import com.yourheadline.dao.UserDAO;
import com.yourheadline.entity.UserEntity;
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

    private static Validation instance;
    @PostConstruct
    public void init()
    {
        instance = this;
        instance.userDAO = this.userDAO;
    }



    public boolean checkAuthor(String username, String password)
    {
        List<UserEntity> list = instance.userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("author")){
                return true;
            }
        }
        return false;
    }

    public boolean checkEditor(String username, String password)
    {
        List<UserEntity> list = instance.userDAO.findByUserName(username);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserType().equals("editor")){
                return true;
            }
        }
        return false;
    }


    public boolean checkAuthor(int authorId, String authorName, String password) {
        List<UserEntity> list = instance.userDAO.findByUserName(authorName);
        if (!list.isEmpty()) {
            UserEntity u =list.get(0);
            if (u.getPassword().equals(password) && u.getUserId() == authorId && u.getUserType().equals("author")){
                return true;
            }
        }
        return false;
    }
}
