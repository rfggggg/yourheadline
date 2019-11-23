package com.yourheadline.dao;


import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.model.ArticleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDAO extends JpaRepository<ArticleEntity,Long> {
}
