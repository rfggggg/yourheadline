package com.yourheadline;

import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.model.ArticleInfoEntity;
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

}

