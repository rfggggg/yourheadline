package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_like_article", schema = "yhl", catalog = "")
public class UserLikeArticleEntity {
    private int likeId;
    private Integer userId;
    private Integer articleId;
    private Date addTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    public int getLikeId() {
        return likeId;
    }

    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
                Objects.equals(userId, that.userId) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeId, userId, articleId, addTime);
    }
}
