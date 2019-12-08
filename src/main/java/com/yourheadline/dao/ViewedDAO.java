package com.yourheadline.dao;


import com.yourheadline.entity.ViewedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewedDAO extends JpaRepository<ViewedEntity, Long> {
}
