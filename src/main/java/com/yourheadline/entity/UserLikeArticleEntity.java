package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_like_article", schema = "yourheadline", catalog = "")
public class UserLikeArticleEntity {
    private int likeId;
    private Integer userName;
    private Integer articleId;
    private Date addTime;

    @Id
    @Column(name = "like_id")
    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    @Basic
    @Column(name = "user_name")
    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "article_id")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "add_time")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLikeArticleEntity that = (UserLikeArticleEntity) o;
        return likeId == that.likeId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeId, userName, articleId, addTime);
    }
}
