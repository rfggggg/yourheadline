package com.yourheadline.dao;

import com.yourheadline.entity.ArticleUncheckedEntity;
import com.yourheadline.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleUncheckedDAO extends JpaRepository<ArticleUncheckedEntity, Long> {
    @Query(value = "call check_article(?1, ?2)", nativeQuery = true)
    void checkArticle(int articleUncheckedId, int editorId);
}
