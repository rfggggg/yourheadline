package com.yourheadline.dao;

import com.yourheadline.entity.EditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorDAO extends JpaRepository<EditorEntity, Long> {

}
