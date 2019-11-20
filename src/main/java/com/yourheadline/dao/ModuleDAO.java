package com.yourheadline.dao;

import com.yourheadline.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleDAO extends JpaRepository<ModuleEntity, Integer> {

}
