package com.yourheadline;

import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class YourheadlineApplicationTests {

    @Autowired
    ArticleInfoDAO articleInfoDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void testArticleInfoDAO_selectCollectionByUserId() {
        List<ArticleInfo> ai;
        ai = articleInfoDAO.selectCollectionByUserId(1);
        System.out.println(ai);
    }

    @Test
    void testArticleInfoDAO_selectHistoryByUserId() {
        List<ArticleInfo> ai;
        ai = articleInfoDAO.selectHistoryByUserId(1);
        System.out.println(ai);
    }

    @Test
    void testArticleInfoDAO_findAll() {
        List<ArticleInfo> ai;
        ai = articleInfoDAO.findAll();
        System.out.println(ai);
    }

    @Test
    void testArticleInfoDAO_findArticleInfoByModuleId() {
        List<ArticleInfo> ai;
        ai = articleInfoDAO.findArticleInfoByModuleId(1);
        System.out.println(ai);
    }

    @Test
    void testArticleInfoDAO_findArticleInfoByAuthorId() {
        List<ArticleInfo> ai;
        ai = articleInfoDAO.findArticleInfoByAuthorId(1);
        System.out.println(ai);
    }
}

