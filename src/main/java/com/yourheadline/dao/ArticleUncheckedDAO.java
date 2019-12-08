package com.yourheadline.dao;

import com.yourheadline.entity.ArticleUncheckedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleUncheckedDAO extends JpaRepository<ArticleUncheckedEntity, Long> {
    @Transactional
    @Modifying
    void deleteByArticleId(int articleId);

    List<ArticleUncheckedEntity> findByArticleId(int articleId);
}
