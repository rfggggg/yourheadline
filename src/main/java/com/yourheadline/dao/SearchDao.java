package com.yourheadline.dao;

import com.yourheadline.model.SearchViewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchDao extends JpaRepository<SearchViewInfo, Long> {

    @Query(value = "select * from searchView a where a.article_title like %:keyword% OR a.article_intro like %:keyword% OR a.article_text like %:keyword% OR a.user_name like %:keyword%", nativeQuery = true)
    List<SearchViewInfo> findAllByKeyWord(@Param("keyword") String keyword);
}
