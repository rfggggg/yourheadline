package com.yourheadline.ajaxapi;

import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.dao.ArticleUncheckedDAO;
import com.yourheadline.model.ArticleInfo;
import com.yourheadline.service.Validation;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletEditorFunc {
    @Autowired
    private ArticleUncheckedDAO articleUncheckedDAO;
    @Autowired
    private ArticleInfoDAO articleInfoDAO;
    @Autowired
    Validation validation;

    @PostMapping("api/check-article")
    public int checkArticle(@RequestParam int articleUncheckedId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        if (validation.checkEditor(editorName, password)) {
            return articleUncheckedDAO.checkArticle(editorId, articleUncheckedId);
        }
        return 0;
    }

    @PostMapping("api/unchecked-article")
    @ResponseBody
    public Map<String, Object> getData(@RequestBody Map<String, String> inMap) {
        String editorName = "";
        String password = "";
        if (!inMap.containsKey("editorName") || !inMap.containsKey("password")){
            return null;
        }
        else{
            editorName = inMap.get("editorName");
            password = inMap.get("password");
        }
        if (validation.checkEditor(editorName, password)) {
            Map<String, Object> map = new HashMap<String, Object>();

            List<ArticleInfo> aiList = articleInfoDAO.selectArticleUnchecked();
            map.put("article_list", aiList);
            return map;
        }
        return null;
    }
}
