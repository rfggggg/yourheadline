package com.yourheadline.dao;

import com.yourheadline.entity.ModuleEntity;
import com.yourheadline.entity.ViewedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryDAO extends JpaRepository<ViewedEntity, Long> {
}
