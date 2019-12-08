package com.yourheadline.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "comment_info", schema = "yhl", catalog = "")
public class CommentInfoEntity {
    private int commentId;
    private String content;
    private Date addTime;
    private Integer likeNum;
    private Integer articleId;
    private Integer userId;
    private String userName;
    private String userAvatarLink;

    @Id
    @Column(name = "comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "add_time")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "like_num")
    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_avatar_link")
    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentInfoEntity that = (CommentInfoEntity) o;
        return commentId == that.commentId &&
                Objects.equals(content, that.content) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(likeNum, that.likeNum) &&
                Objects.equals(articleId, that.articleId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userAvatarLink, that.userAvatarLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, content, addTime, likeNum, articleId, userId, userName, userAvatarLink);
    }
}
