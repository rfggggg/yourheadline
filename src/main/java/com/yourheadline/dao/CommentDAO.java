package com.yourheadline.dao;

import com.yourheadline.entity.CommentEntity;
import com.yourheadline.model.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDAO extends JpaRepository<CommentInfo, Integer>{
    List<CommentInfo> findByArticleId(int id);
    CommentEntity findByCommentId(int id);
    CommentEntity save(CommentEntity newComment);
}