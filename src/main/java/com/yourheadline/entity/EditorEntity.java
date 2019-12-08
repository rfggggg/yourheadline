package com.yourheadline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "editor", schema = "yhl", catalog = "")
public class EditorEntity {
    private int editorId;
    private Integer workerId;

    @Id
    @Column(name = "editor_id")
    public int getEditorId() {
        return editorId;
    }

    public void setEditorId(int editorId) {
        this.editorId = editorId;
    }

    @Basic
    @Column(name = "worker_id")
    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditorEntity that = (EditorEntity) o;
        return editorId == that.editorId &&
                Objects.equals(workerId, that.workerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(editorId, workerId);
    }
}
