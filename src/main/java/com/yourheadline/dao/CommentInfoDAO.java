package com.yourheadline.dao;

import com.yourheadline.model.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInfoDAO extends JpaRepository<CommentInfo, Integer> {
    List<CommentInfo> findByArticleId(int id);
}
