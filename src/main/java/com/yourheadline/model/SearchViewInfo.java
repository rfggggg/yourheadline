package com.yourheadline.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "searchView", schema = "yourheadline", catalog = "")
public class SearchViewInfo {
    @Id
    @GeneratedValue
    @Autowired
    public int articleId;

    @Autowired
    public String articleTitle;

    @Autowired
    public String articleIntro;

    @Autowired
    public String articleText;

    @Autowired
    public int userId;

    @Autowired
    public String userName;

    @Autowired
    public String coverLink;

    @Autowired
    public Date addTime;

    public SearchViewInfo(){}
    public SearchViewInfo(
            int articleId,
            String articleTitle,
            String articleIntro,
            String articleText,
            int userId,
            String userName,
            String coverLink,
            Date addTime
    ){
        this.articleId = articleId;
        this.articleIntro = articleIntro;
        this.articleTitle = articleTitle;
        this.articleText = articleText;
        this.userId = userId;
        this.userName = userName;
        this.coverLink = coverLink;
        this.addTime = addTime;
    }

}
