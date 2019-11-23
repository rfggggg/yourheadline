package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "article", schema = "yourheadline", catalog = "")
public class ArticleEntity {
    private int articleId;
    private Integer authorId;
    private Integer editorId;
    private Integer moduleId;
    private String articleTitle;
    private String articleIntro;
    private String articleText;
    private String coverLink;
    private Date addTime;

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
    @Column(name = "article_text")
    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
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
        ArticleEntity that = (ArticleEntity) o;
        return articleId == that.articleId &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(editorId, that.editorId) &&
                Objects.equals(moduleId, that.moduleId) &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(articleIntro, that.articleIntro) &&
                Objects.equals(articleText, that.articleText) &&
                Objects.equals(coverLink, that.coverLink) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, authorId, editorId, moduleId, articleTitle, articleIntro, articleText, coverLink, addTime);
    }
}
