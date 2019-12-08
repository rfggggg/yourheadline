package com.yourheadline.dao;

import com.yourheadline.model.ArticleUncheckedInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleUncheckedInfoDAO extends JpaRepository<ArticleUncheckedInfoEntity, Long> {

}
