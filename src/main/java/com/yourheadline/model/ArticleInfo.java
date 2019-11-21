package com.yourheadline.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class ArticleInfo {

    @Id
    @GeneratedValue
    @Autowired
    public int articleId;
    @Autowired
    public Integer authorId;
    @Autowired
    public Integer editorId;
    @Autowired
    public Integer moduleId;
    @Autowired
    public String articleTitle;
    @Autowired
    public String articleText;
    @Autowired
    public Date addTime;
    @Autowired
    public int likeNum;

    @Autowired
    public String authorName;
    @Autowired
    public String editorName;


    public ArticleInfo(){}
    public ArticleInfo(int articleId,
                       Integer authorId,
                       Integer editorId,
                       Integer moduleId,
                       String articleTitle,
                       String articleText,
                       Date addTime,
                       int likeNum,
                       String authorName)
    {
        this.articleId = articleId;
        this.authorId = authorId;
        this.editorId = editorId;
        this.moduleId = moduleId;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.addTime = addTime;
        this.likeNum = likeNum;
        this.authorName = authorName;
    }
    public ArticleInfo(int articleId, 
                       Integer authorId, 
                       Integer editorId, 
                       Integer moduleId, 
                       String articleTitle, 
                       String articleText, 
                       Date addTime, 
                       int likeNum,
                       String authorName,
                       String editorName)
    {
        this.articleId = articleId;
        this.authorId = authorId;
        this.editorId = editorId;
        this.moduleId = moduleId;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.addTime = addTime;
        this.likeNum = likeNum;
        this.authorName = authorName;
        this.editorName = editorName;
    }
}
