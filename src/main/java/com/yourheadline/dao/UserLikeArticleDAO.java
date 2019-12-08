package com.yourheadline.dao;

import com.yourheadline.entity.UserLikeArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
    public interface UserLikeArticleDAO extends JpaRepository<UserLikeArticleEntity, Integer> {
    UserLikeArticleEntity save(UserLikeArticleEntity newLike);
    List<UserLikeArticleEntity> findByUserIdAndArticleId(int uid,int aid);
    void deleteByUserIdAndArticleId(int uid,int aid);

}
