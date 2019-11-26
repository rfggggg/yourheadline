package com.yourheadline.dao;

import com.yourheadline.entity.UserLikeArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface UserLikeArticleDAO extends JpaRepository<UserLikeArticleEntity, Integer> {
  //  UserLikeArticleEntity save(UserLikeArticleEntity newLike);
    }
