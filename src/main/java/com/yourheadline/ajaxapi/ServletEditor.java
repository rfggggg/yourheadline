package com.yourheadline.ajaxapi;


import com.yourheadline.dao.*;
import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.entity.ArticleUncheckedEntity;
import com.yourheadline.model.ArticleInfoEntity;
import com.yourheadline.model.ArticleUncheckedInfoEntity;
import com.yourheadline.model.AuthorApplyInfoEntity;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.crypto.AEADBadTagException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletEditor {
    @Autowired
    Validation validation;
    @Autowired
    AuthorDAO authorDAO;
    @Autowired
    AuthorApplyInfoDAO authorApplyInfoDAO;
    @Autowired
    ArticleInfoDAO articleInfoDAO;
    @Autowired
    ArticleDAO articleDAO;
    @Autowired
    ArticleUncheckedDAO articleUncheckedDAO;
    @Autowired
    ArticleUncheckedInfoDAO articleUncheckedInfoDAO;


    //接收上传的作者申请


    @GetMapping("/api/editor/all-author-apply")
    @ResponseBody
    public Map<String, Object> allAuthorApply(@RequestParam String editorName,
                                              @RequestParam String password,
                                              @RequestParam int startId)
    {
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorName, password)!=null) {
            PageRequest pr = PageRequest.of(startId/10, 10);
            List<AuthorApplyInfoEntity> uList = authorApplyInfoDAO.findAll(pr).getContent();
            if (uList.isEmpty()){
                map.put("status", "Empty");
            }
            else {
                map.put("status", "OK");
                map.put("authorList", uList);
            }
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }


    @GetMapping("api/editor/authorize-author")
    @ResponseBody
    public Map<String, Object> authorizeAuthor(@RequestParam int authorId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorId, editorName, password) != null) {
            authorDAO.checkAuthor(editorId, authorId);
            map.put("status", "OK");
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }

    @GetMapping("api/editor/decline-author")
    @ResponseBody
    public Map<String, Object> declineAuthor(@RequestParam int authorId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password){
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorId, editorName, password) != null) {
            authorDAO.declineAuthor(authorId);
            map.put("status", "OK");
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }


    @GetMapping("api/editor/ban-author")
    public Map<String, Object> banAuthor(@RequestParam int authorId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password){
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorId, editorName, password) != null) {
            authorDAO.banAuthor(authorId);
            map.put("status", "OK");
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }





    @GetMapping("api/editor/all-unchecked-article")
    @ResponseBody
    public Map<String, Object> allArticlePendingCheck(@RequestParam String editorName, @RequestParam String password, @RequestParam int startId) {
        Map<String, Object> map = new HashMap<>();

        if (validation.checkEditor(editorName, password) != null) {
            PageRequest pr = PageRequest.of(startId / 10, 10);
            List<ArticleUncheckedInfoEntity> aiList = articleUncheckedInfoDAO.findAll(pr).getContent();

            if (aiList.isEmpty()) {
                map.put("status", "Empty");
            } else {
                map.put("status", "OK");
                map.put("articleList", aiList);
            }
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }




    @GetMapping("api/editor/publish-article")
    @ResponseBody
    public Map<String, Object> publishArticle(@RequestParam int articleId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        String status = "Fail";

        if (validation.checkEditor(editorName, password) != null) {
            List<ArticleUncheckedEntity> aueList = articleUncheckedDAO.findByArticleId(articleId);
            if (!aueList.isEmpty()){
                ArticleUncheckedEntity aue = aueList.get(0);
                ArticleEntity ae = new ArticleEntity();
                ae.setEditorId(editorId);
                ae.setAuthorId(aue.getAuthorId());
                ae.setModuleId(aue.getModuleId());

                ae.setCoverLink(aue.getCoverLink());
                ae.setArticleText(aue.getArticleText());
                ae.setArticleTitle(aue.getArticleTitle());
                ae.setAddTime(aue.getAddTime());
                articleUncheckedDAO.deleteByArticleId(articleId);
                articleDAO.save(ae);

                status="OK";
            }
        }
        else {
            status= "FailCheckingEditor";
        }
        map.put("status", status);
        return map;
    }

    @GetMapping("api/editor/decline-article")
    @ResponseBody
    public Map<String, Object> declineArticle(@RequestParam int articleId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorName, password) != null) {
            articleUncheckedDAO.deleteByArticleId(articleId);
            map.put("status", "OK");
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }

    @GetMapping("api/editor/delete-article")
    @ResponseBody
    public Map<String, Object> deleteArticle(@RequestParam int articleId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorName, password) != null) {
            articleDAO.deleteByArticleId(articleId);
            map.put("status", "OK");
        }
        else {
            map.put("status", "FailCheckingEditor");
        }
        return map;
    }
}
