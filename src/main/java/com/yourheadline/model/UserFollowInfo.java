package com.yourheadline.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "user_like_author_info", schema = "yourheadline", catalog = "")
public class UserFollowInfo {
    @Id
    @GeneratedValue
    @Autowired
    public int followId;
    @Autowired
    public Integer userId;
    @Autowired
    public Integer authorId;
    @Autowired
    public String authorName;
    @Autowired
    public String authorAvatarLink;
    @Autowired
    public Date addTime;
    @Autowired
    public Integer followNum;


    public UserFollowInfo(){}
    public UserFollowInfo(int followId,
                          Integer userId,
                          Integer authorId,
                          String authorName,
                          String authorAvatarLink,
                          Date addTime,
                          Integer followNum)
    {
        this.followId = followId;
        this.userId = userId;
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorAvatarLink = authorAvatarLink;
        this.addTime = addTime;
        this.followNum = followNum;
    }
}
