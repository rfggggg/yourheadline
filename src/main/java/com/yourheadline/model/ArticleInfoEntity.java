package com.yourheadline.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "article_info", schema = "yhl", catalog = "")
public class ArticleInfoEntity {
    private int articleId;
    private Integer authorId;
    private Integer editorId;
    private Integer moduleId;
    private String articleTitle;
    private String articleIntro;
    private Date addTime;
    private String coverLink;
    private String authorName;
    private String authorAvatarLink;
    private long likeNum;

    @Id
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "author_id")
    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "editor_id")
    public Integer getEditorId() {
        return editorId;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    @Basic
    @Column(name = "module_id")
    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "article_intro")
    public String getArticleIntro() {
        return articleIntro;
    }

    public void setArticleIntro(String articleIntro) {
        this.articleIntro = articleIntro;
    }

    @Basic
    @Column(name = "add_time")
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "cover_link")
    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
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
    @Column(name = "author_avatar_link")
    public String getAuthorAvatarLink() {
        return authorAvatarLink;
    }

    public void setAuthorAvatarLink(String authorAvatarLink) {
        this.authorAvatarLink = authorAvatarLink;
    }

    @Basic
    @Column(name = "like_num")
    public long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleInfoEntity that = (ArticleInfoEntity) o;
        return articleId == that.articleId &&
                likeNum == that.likeNum &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(editorId, that.editorId) &&
                Objects.equals(moduleId, that.moduleId) &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(articleIntro, that.articleIntro) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(coverLink, that.coverLink) &&
                Objects.equals(authorName, that.authorName) &&
                Objects.equals(authorAvatarLink, that.authorAvatarLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, authorId, editorId, moduleId, articleTitle, articleIntro, addTime, coverLink, authorName, authorAvatarLink, likeNum);
    }
}
