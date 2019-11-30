package com.yourheadline.dao;

import com.yourheadline.entity.UserLikeCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserLikeCommentDAO extends JpaRepository<UserLikeCommentEntity, Integer> {
    UserLikeCommentEntity save(UserLikeCommentEntity newLike);
    void deleteByUserIdAndCommentId(int uid,int cid);
}