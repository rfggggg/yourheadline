package com.yourheadline.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "article_info", schema = "yourheadline", catalog = "")
public class ArticleInfo{

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
    public String articleIntro;
    @Autowired
    public Date addTime;
<<<<<<< HEAD
    @Autowired
    public String coverLink;
=======
>>>>>>> xy

    @Autowired
    public String authorName;
    @Autowired
    public String authorAvatarLink;
    @Autowired
    public int likeNum;


    public ArticleInfo(){}
    public ArticleInfo(int articleId,
                       Integer authorId,
                       Integer editorId,
                       Integer moduleId,
                       String articleTitle,
                       String articleIntro,
                       Date addTime,
<<<<<<< HEAD
                       String coverLink,
=======
>>>>>>> xy
                       String authorName,
                       String authorAvatarLink,
                       int likeNum)
    {
        this.articleId = articleId;
        this.authorId = authorId;
        this.editorId = editorId;
        this.moduleId = moduleId;
        this.articleTitle = articleTitle;
        this.articleIntro = articleIntro;
        this.addTime = addTime;
<<<<<<< HEAD
        this.coverLink = coverLink;
=======
>>>>>>> xy
        this.authorName = authorName;
        this.authorAvatarLink = authorAvatarLink;
        this.likeNum = likeNum;
    }
}
