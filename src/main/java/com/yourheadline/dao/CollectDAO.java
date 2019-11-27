package com.yourheadline.dao;

import com.yourheadline.entity.CollectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CollectDAO extends JpaRepository<CollectEntity,Long> {

    CollectEntity save(CollectEntity newCollect);
    List<CollectEntity> findByUserIdAndArticleId(int uid,int aid);
    void deleteByUserIdAndArticleId(int uid,int aid);

}
