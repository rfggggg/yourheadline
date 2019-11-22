package com.yourheadline.dao;

import com.yourheadline.entity.CollectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectDAO extends JpaRepository<CollectEntity,Long> {

}
