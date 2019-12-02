package com.yourheadline.dao;

import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.model.AuthorInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorDAO extends JpaRepository<AuthorEntity,Long> {
    @Transactional
    @Modifying
    @Query(value = "call check_author(?1,?2)",nativeQuery = true)
    void checkAuthor(int editorId, int authorId);

    List<AuthorEntity> findByAuthorId(int id);

}
