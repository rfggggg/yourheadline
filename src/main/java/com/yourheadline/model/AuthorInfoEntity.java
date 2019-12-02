package com.yourheadline.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "author_info", schema = "yourheadline", catalog = "")
public class AuthorInfoEntity {
    private int authorId;
    private String authorName;
    private String idCardBack;
    private String idCardFront;
    private String applyText;
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
    @Column(name = "author_name")
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    @Basic
    @Column(name = "apply_time")
    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorInfoEntity that = (AuthorInfoEntity) o;
        return authorId == that.authorId &&
                Objects.equals(authorName, that.authorName) &&
                Objects.equals(idCardBack, that.idCardBack) &&
                Objects.equals(idCardFront, that.idCardFront) &&
                Objects.equals(applyText, that.applyText) &&
                Objects.equals(applyTime, that.applyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, idCardBack, idCardFront, applyText, applyTime);
    }

}
