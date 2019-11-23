package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "author_apply", schema = "yourheadline", catalog = "")
public class AuthorApplyEntity {
    private int id;
    private Date applyTime;
    private String applicationFileLink;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "apply_time")
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "application_file_link")
    public String getApplicationFileLink() {
        return applicationFileLink;
    }

    public void setApplicationFileLink(String applicationFileLink) {
        this.applicationFileLink = applicationFileLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorApplyEntity that = (AuthorApplyEntity) o;
        return id == that.id &&
                Objects.equals(applyTime, that.applyTime) &&
                Objects.equals(applicationFileLink, that.applicationFileLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, applyTime, applicationFileLink);
    }
}
