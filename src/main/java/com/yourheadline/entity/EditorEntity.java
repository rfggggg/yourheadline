package com.yourheadline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "editor", schema = "yourheadline", catalog = "")
public class EditorEntity {
    private int editorId;
    private String editorAccount;
    private Integer editorWorkerId;
    private String editorPassword;

    @Id
    @Column(name = "editor_id")
    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    @Basic
    @Column(name = "editor_account")
    public String getEditorAccount() {
        return editorAccount;
    }

    public void setEditorAccount(String editorAccount) {
        this.editorAccount = editorAccount;
    }

    @Basic
    @Column(name = "editor_worker_id")
    public Integer getEditorWorkerId() {
        return editorWorkerId;
    }

    public void setEditorWorkerId(Integer editorWorkerId) {
        this.editorWorkerId = editorWorkerId;
    }

    @Basic
    @Column(name = "editor_password")
    public String getEditorPassword() {
        return editorPassword;
    }

    public void setEditorPassword(String editorPassword) {
        this.editorPassword = editorPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditorEntity that = (EditorEntity) o;
        return editorId == that.editorId &&
                Objects.equals(editorAccount, that.editorAccount) &&
                Objects.equals(editorWorkerId, that.editorWorkerId) &&
                Objects.equals(editorPassword, that.editorPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editorId, editorAccount, editorWorkerId, editorPassword);
    }
}
