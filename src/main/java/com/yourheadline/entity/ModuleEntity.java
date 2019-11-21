package com.yourheadline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "module", schema = "yourheadline", catalog = "")
public class ModuleEntity {
    private int moduleId;
    private String moduleName;
    private String photoLink;

    @Id
    @Column(name = "module_id")
    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "photo_link")
    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuleEntity that = (ModuleEntity) o;
        return moduleId == that.moduleId &&
                Objects.equals(moduleName, that.moduleName) &&
                Objects.equals(photoLink, that.photoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleId, moduleName, photoLink);
    }
}
