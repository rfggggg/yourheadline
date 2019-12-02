package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "yourheadline", catalog = "")
public class AuthorEntity {
    private int authorId;
    private Integer authorizeEditorId;
    private Date authorizeDate;
    private String idCardBack;
    private String idCardFront;
    private String applyText;
    private Integer authorized;
    private Date applyTime;

    @Id
    @Column(name = "author_id")
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "authorize_editor_id")
    public Integer getAuthorizeEditorId() {
        return authorizeEditorId;
    }

    public void setAuthorizeEditorId(Integer authorizeEditorId) {
        this.authorizeEditorId = authorizeEditorId;
    }

    @Basic
    @Column(name = "authorize_date")
    public Date getAuthorizeDate() {
        return authorizeDate;
    }

    public void setAuthorizeDate(Date authorizeDate) {
        this.authorizeDate = authorizeDate;
    }

    @Basic
    @Column(name = "id_card_back")
    public String getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(String idCardBack) {
        this.idCardBack = idCardBack;
    }

    @Basic
    @Column(name = "id_card_front")
    public String getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(String idCardFront) {
        this.idCardFront = idCardFront;
    }

    @Basic
    @Column(name = "apply_text")
    public String getApplyText() {
        return applyText;
    }

    public void setApplyText(String applyText) {
        this.applyText = applyText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return authorId == that.authorId &&
                Objects.equals(authorizeEditorId, that.authorizeEditorId) &&
                Objects.equals(authorizeDate, that.authorizeDate) &&
                Objects.equals(idCardBack, that.idCardBack) &&
                Objects.equals(idCardFront, that.idCardFront) &&
                Objects.equals(applyText, that.applyText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorizeEditorId, authorizeDate, idCardBack, idCardFront, applyText);
    }

    @Basic
    @Column(name = "authorized")
    public Integer getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Integer authorized) {
        this.authorized = authorized;
    }

    @Basic
    @Column(name = "apply_time")
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }
}
