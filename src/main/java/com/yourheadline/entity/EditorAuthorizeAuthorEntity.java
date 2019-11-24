package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "editor_authorize_author", schema = "yourheadline", catalog = "")
public class EditorAuthorizeAuthorEntity {
    private int authorId;
    private Integer authorizeEditorId;
    private Date authorizeDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditorAuthorizeAuthorEntity that = (EditorAuthorizeAuthorEntity) o;
        return authorId == that.authorId &&
                Objects.equals(authorizeEditorId, that.authorizeEditorId) &&
                Objects.equals(authorizeDate, that.authorizeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorizeEditorId, authorizeDate);
    }
}
