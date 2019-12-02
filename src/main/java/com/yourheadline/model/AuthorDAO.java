package com.yourheadline.model;

import com.yourheadline.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorDAO extends JpaRepository<AuthorEntity, Long> {
    @Query(value = "call check_author(?1, ?2)", nativeQuery = true)
    List<AuthorEntity> checkAuthor(int editorId, int authorId);

    List<AuthorEntity> findByAuthorId(int id);
}
