package com.yourheadline.dao;

import com.yourheadline.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<CommentEntity, Integer>{
    List<CommentEntity> findByArticleId(int id);
    CommentEntity findByCommentId(int id);
    CommentEntity save(CommentEntity newComment);
}