package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_like_comment", schema = "yourheadline", catalog = "")
public class UserLikeCommentEntity {
    private int likeId;
    private Integer userId;
    private Integer commentId;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "comment_id")
    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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
        UserLikeCommentEntity that = (UserLikeCommentEntity) o;
        return likeId == that.likeId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(commentId, that.commentId) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likeId, userId, commentId, addTime);
    }
}
