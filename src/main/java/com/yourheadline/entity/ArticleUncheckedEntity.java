package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "article_unchecked", schema = "yourheadline", catalog = "")
public class ArticleUncheckedEntity {
    private int id;
    private Integer authorId;
    private Integer moduleId;
    private String articleTitle;
    private String articleIntro;
    private String articleText;
    private Date applyTime;
    private String coverLink;

    public ArticleUncheckedEntity(Integer authorId,
                                  Integer moduleId,
                                  String articleTitle,
                                  String articleIntro,
                                  String articleText,
                                  Date applyTime)
    {
        this.authorId = authorId;
        this.moduleId = moduleId;
        this.articleTitle = articleTitle;
        this.articleIntro = articleIntro;
        this.articleText = articleText;
        this.applyTime = applyTime;
    }

    public ArticleUncheckedEntity(int id,
                                  Integer authorId,
                                  Integer moduleId,
                                  String articleTitle,
                                  String articleIntro,
                                  String articleText,
                                  Date applyTime)
    {
        this.id = id;
        this.authorId = authorId;
        this.moduleId = moduleId;
        this.articleTitle = articleTitle;
        this.articleIntro = articleIntro;
        this.articleText = articleText;
        this.applyTime = applyTime;
    }


    public ArticleUncheckedEntity() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        ArticleUncheckedEntity that = (ArticleUncheckedEntity) o;
        return id == that.id &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(moduleId, that.moduleId) &&
                Objects.equals(articleTitle, that.articleTitle) &&
                Objects.equals(articleIntro, that.articleIntro) &&
                Objects.equals(articleText, that.articleText) &&
                Objects.equals(applyTime, that.applyTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorId, moduleId, articleTitle, articleIntro, articleText, applyTime);
<<<<<<< HEAD
=======
    }

    @Basic
    @Column(name = "cover_link")
    public String getCoverLink() {
        return coverLink;
    }

    public void setCoverLink(String coverLink) {
        this.coverLink = coverLink;
>>>>>>> xy
    }
}
