package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_chase_key", schema = "yourheadline", catalog = "")
public class UserChaseKeyEntity {
    private int keyId;
    private Integer userId;
    private String keyWord;
    private Date lastChaseTime;
    private Date addTime;

    @Id
    @Column(name = "key_id")
    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
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
    @Column(name = "key_word")
    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Basic
    @Column(name = "last_chase_time")
    public Date getLastChaseTime() {
        return lastChaseTime;
    }

    public void setLastChaseTime(Date lastChaseTime) {
        this.lastChaseTime = lastChaseTime;
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
        UserChaseKeyEntity that = (UserChaseKeyEntity) o;
        return keyId == that.keyId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(keyWord, that.keyWord) &&
                Objects.equals(lastChaseTime, that.lastChaseTime) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId, userId, keyWord, lastChaseTime, addTime);
    }
}
