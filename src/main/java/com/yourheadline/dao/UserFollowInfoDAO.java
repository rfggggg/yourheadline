package com.yourheadline.dao;

import com.yourheadline.model.UserFollowInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFollowInfoDAO extends JpaRepository<UserFollowInfo, Integer> {
    List<UserFollowInfo> findByUserId(Integer userId);
    List<UserFollowInfo> findByFollowId(Integer userId);
}
