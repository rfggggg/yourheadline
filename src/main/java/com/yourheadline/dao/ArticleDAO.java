package com.yourheadline.dao;


import com.yourheadline.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO extends JpaRepository<ArticleEntity,Long> {
    List<ArticleEntity> findByModuleId(int id);
    ArticleEntity findByArticleId(int id);
}
