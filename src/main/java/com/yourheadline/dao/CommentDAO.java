package com.yourheadline.dao;

import com.yourheadline.entity.CommentEntity;
import com.yourheadline.model.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CommentDAO extends JpaRepository<CommentEntity, Integer>{
    CommentEntity findByCommentId(int id);
    CommentEntity save(CommentEntity newComment);
}