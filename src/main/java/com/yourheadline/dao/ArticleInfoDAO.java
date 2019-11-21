package com.yourheadline.dao;

import com.yourheadline.model.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleInfoDAO extends JpaRepository<ArticleInfo, Long> {
    @Query("select a.articleId, a.authorId, a.editorId, a.moduleId, a.articleTitle, a.articleText, a.addTime, a.likeNum, au.authorName from ArticleEntity a left join AuthorEntity au")
    List<ArticleInfo> findInfo();
}
