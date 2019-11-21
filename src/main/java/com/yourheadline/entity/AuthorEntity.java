package com.yourheadline.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "author", schema = "yourheadline", catalog = "")
public class AuthorEntity {
    private int authorId;
    private String authorName;
    private String authorAvartarLink;
    private Date addTime;


//    老的用法，用@OneToMany和@ManyToOne的方法，注释掉不要了
//    private List<ArticleEntity> articleEntityList = new ArrayList<ArticleEntity>();
//    @OneToMany(fetch = FetchType.LAZY)
//    public List<ArticleEntity> getArticleEntityList() { return articleEntityList; }
//    public void setArticleEntityList(List<ArticleEntity> list) { this.articleEntityList = list; }

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
    @Column(name = "author_avartar_link")
    public String getAuthorAvartarLink() {
        return authorAvartarLink;
    }

    public void setAuthorAvartarLink(String authorAvartarLink) {
        this.authorAvartarLink = authorAvartarLink;
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
        AuthorEntity that = (AuthorEntity) o;
        return authorId == that.authorId &&
                Objects.equals(authorName, that.authorName) &&
                Objects.equals(authorAvartarLink, that.authorAvartarLink) &&
                Objects.equals(addTime, that.addTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, authorName, authorAvartarLink, addTime);
    }
}
