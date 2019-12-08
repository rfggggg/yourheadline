package com.yourheadline.dao;

import com.yourheadline.entity.CommentEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.model.UserPublicInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPublicInfoDAO extends JpaRepository<UserPublicInfoEntity, Long> {
    @Query(value = "select * from user_public_info where user_id in (select distinct author_id as user_id from follow where user_id=?1)", nativeQuery = true)
    Page<UserPublicInfoEntity> selectFollowingAuthor(int userId, Pageable pr);

    List<UserPublicInfoEntity> findByUserId(int userId);
}
