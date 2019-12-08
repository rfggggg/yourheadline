package com.yourheadline.dao;


import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.model.ArticleInfoEntity;
import com.yourheadline.model.CommentInfoEntity;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleDAO extends JpaRepository<ArticleEntity,Long> {
    List<ArticleEntity> findByArticleId(int id);
    Page<ArticleEntity> findAll(Pageable pageable);

    @Transactional
    @Modifying
    void deleteByArticleId(int articleId);
}
