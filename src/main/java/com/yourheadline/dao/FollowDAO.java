package com.yourheadline.dao;

import com.yourheadline.entity.FollowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FollowDAO extends JpaRepository<FollowEntity, Integer> {
    FollowEntity save(FollowEntity newFollow);
    List<FollowEntity> findByUserIdAndAuthorId(int uid, int aid);
    void deleteByUserIdAndAuthorId(int uid,int aid);
}
