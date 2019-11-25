package com.yourheadline.dao;

import com.yourheadline.entity.ArticleUncheckedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleUncheckedDAO extends JpaRepository<ArticleUncheckedEntity, Long> {
}
