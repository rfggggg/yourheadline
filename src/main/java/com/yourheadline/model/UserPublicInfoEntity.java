package com.yourheadline.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user_public_info", schema = "yhl", catalog = "")
public class UserPublicInfoEntity {
    private String userName;
    private String userType;
    private String gender;
    private Date addTime;
    private int userId;
    private String userAvatarLink;

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        UserPublicInfoEntity that = (UserPublicInfoEntity) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userType, gender, addTime);
    }

    @Basic
    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_avatar_link")
    public String getUserAvatarLink() {
        return userAvatarLink;
    }

    public void setUserAvatarLink(String userAvatarLink) {
        this.userAvatarLink = userAvatarLink;
    }
}
