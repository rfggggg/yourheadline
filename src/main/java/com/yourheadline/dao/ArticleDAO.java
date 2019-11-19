package com.yourheadline.dao;


import com.yourheadline.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDAO extends JpaRepository<ArticleEntity,Long> {
}
