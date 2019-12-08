package com.yourheadline.dao;

import com.yourheadline.model.AuthorApplyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorApplyInfoDAO extends JpaRepository<AuthorApplyInfoEntity, Long> {
    @Override
    @Query(value = "select * from author_apply_info", nativeQuery = true)
    List<AuthorApplyInfoEntity> findAll();
}
