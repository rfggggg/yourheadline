package com.yourheadline.dao;

import com.yourheadline.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowDAO extends JpaRepository<FollowEntity, Integer> {
}
