package com.yourheadline.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comment_info", schema = "yourheadline", catalog = "")
public class CommentInfo {
    @Id
    @GeneratedValue
    @Autowired
    public int commentId;
    @Autowired
    public String content;
    @Autowired
    public Date addTime;
    @Autowired
    public Integer likeNum;
    @Autowired
    public int articleId;
    @Autowired
    public int userId;
    @Autowired
    public String userName;
    @Autowired
    public String userAvatarLink;
}
