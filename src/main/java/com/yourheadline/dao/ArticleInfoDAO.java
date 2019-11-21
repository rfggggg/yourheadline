package com.yourheadline.dao;

import com.yourheadline.model.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ArticleInfoDAO extends JpaRepository<ArticleInfo, Long> {
    @Query("select new com.yourheadline.model.ArticleInfo(a.articleId, a.authorId, a.editorId, a.moduleId, a.articleTitle, a.articleText, a.addTime, a.likeNum, au.authorName) from ArticleEntity a left join AuthorEntity au on a.authorId = au.authorId")
    List<ArticleInfo> findInfo();
}
