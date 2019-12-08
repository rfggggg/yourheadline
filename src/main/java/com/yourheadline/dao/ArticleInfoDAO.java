package com.yourheadline.dao;

import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.model.ArticleInfoEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleInfoDAO extends JpaRepository<ArticleInfoEntity, Long> {

    Page<ArticleInfoEntity> findAll(Pageable pageable);

    @Query(value = "select * from article_info where article_id in (select article_id from article where checked=0)", nativeQuery = true)
    Page<ArticleInfoEntity> selectUncheckedArticle(Pageable pageable);

    @Query(value = "select * from article_info where article_id in (select distinct article_id from collect where user_id = ?1)", nativeQuery = true)
    Page<ArticleInfoEntity> selectCollectionByUserId(Integer userId, Pageable pageable);

    @Query(value = "select * from article_info where article_id in (select distinct article_id from viewed where user_id = ?1)", nativeQuery = true)
    Page<ArticleInfoEntity> selectHistoryByUserId(Integer userId, Pageable pageable);

    @Query(value = "select * from articleInfo", nativeQuery = true)
    Page<ArticleInfoEntity> selectFeedByUserId(int userId, Pageable pr);

    @Query(value = "select * from article_info where article_id in (select article_id from article where article_title like %:keyword% OR article_text like %:keyword%)", nativeQuery = true)
    Page<ArticleInfoEntity> selectArticleInfoByKeyWord(@Param("keyword") String keyword, Pageable pr);


    //声明接口无需实现即可使用
    Page<ArticleInfoEntity> findByAuthorId(int authorId, Pageable pr);
    Page<ArticleInfoEntity> findByModuleId(int moduleId, Pageable pr);

    List<ArticleInfoEntity> findByArticleId(int articleId);
}
