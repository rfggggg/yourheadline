package com.yourheadline.dao;

import com.yourheadline.model.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import java.util.List;

public interface ArticleInfoDAO extends JpaRepository<ArticleInfo, Long> {
    @Query(value = "call select_collection_by_user_id(?1)", nativeQuery = true)
    List<ArticleInfo> selectCollectionByUserId(Integer userId);

    @Query(value = "call select_history_by_user_id(?1)", nativeQuery = true)
    List<ArticleInfo> selectHistoryByUserId(Integer userId);


    @Override
    @Query(value = "select * from article_info", nativeQuery = true)
    List<ArticleInfo> findAll();

    //声明接口无需实现即可使用
    List<ArticleInfo> findArticleInfoByAuthorId(Integer authorId);
    List<ArticleInfo> findArticleInfoByModuleId(Integer moduleId);

}
