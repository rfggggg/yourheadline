package com.yourheadline.dao;

import com.yourheadline.model.CommentInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInfoDAO extends JpaRepository<CommentInfoEntity, Integer> {
    Page<CommentInfoEntity> findByArticleId(int id, Pageable pr);
}
