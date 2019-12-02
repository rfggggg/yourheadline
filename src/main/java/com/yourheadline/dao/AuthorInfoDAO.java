package com.yourheadline.dao;

import com.yourheadline.model.AuthorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorInfoDAO extends JpaRepository<AuthorInfoEntity, Long> {
    @Override
    @Query(value = "select * from author_info", nativeQuery = true)
    List<AuthorInfoEntity> findAll();
}
