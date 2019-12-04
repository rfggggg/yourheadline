package com.yourheadline.ajaxapi;


import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.dao.ArticleUncheckedDAO;
import com.yourheadline.dao.AuthorInfoDAO;
import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.dao.AuthorDAO;
import com.yourheadline.entity.UserEntity;
import com.yourheadline.model.ArticleInfo;
import com.yourheadline.model.AuthorInfoEntity;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class ServletAuthorConfirm {
    @Autowired
    Validation validation;
    @Autowired
    AuthorDAO authorDAO;
    @Autowired
    AuthorInfoDAO authorInfoDAO;
    @Autowired
    private ArticleUncheckedDAO articleUncheckedDAO;
    @Autowired
    private ArticleInfoDAO articleInfoDAO;

    //接收上传的作者申请
    @PostMapping("/api/author-confirm")
    public Map<String, String> acceptAuthorConfirm(Integer authorId,
                                             String authorName,
                                             String password,
                                             String idCardBack,
                                             String idCardFront,
                                             String applyText)
    {
        String status = "Fail";
        Map<String, String> map = new HashMap<>();

        if (!validation.checkAuthor(authorId, authorName, password)) {
            status = "FailCheckAuthor";
        }
        else {
            List<AuthorEntity> auList = authorDAO.findByAuthorId(authorId);

            AuthorEntity aue;
            if (auList.isEmpty()) {

            } else {
                aue = auList.get(0);

                aue.setIdCardBack(idCardBack);
                aue.setIdCardFront(idCardFront);
                aue.setApplyText(applyText);
                aue.setApplyTime(new Date(Calendar.getInstance().getTimeInMillis()));
                authorDAO.save(aue);
                status = "Succeed";
            }
        }


        map.put("status", status);
        return map;
    }

    @PostMapping("/api/all-apply")
    public Map<String, Object> listAllApply(@RequestParam String editorName,
                                            @RequestParam String password)
    {
        Map<String, Object> map = new HashMap<>();
        if (validation.checkEditor(editorName, password)) {
            List<AuthorInfoEntity> uList = authorInfoDAO.findAll();
            map.put("hasContent", "yes");
            map.put("authorInfoList", uList);
        }
        else {
            map.put("hasContent", "no");
            map.put("authorInfoList", null);
        }
        return map;
    }

    @PostMapping("api/check-article")
    public String checkArticle(@RequestParam int articleUncheckedId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        if (validation.checkEditor(editorName, password)) {
            articleUncheckedDAO.checkArticle(editorId, articleUncheckedId);
            return "Succeed";
        }
        return "FailCheckingEditor";
    }

    @PostMapping("api/unchecked-article")
    @ResponseBody
    public Map<String, Object> getData(@RequestParam String editorName, @RequestParam String password) {

        if (validation.checkEditor(editorName, password)) {
            Map<String, Object> map = new HashMap<String, Object>();

            List<ArticleInfo> aiList = articleInfoDAO.selectArticleUnchecked();
            map.put("article_list", aiList);
            return map;
        }
        return null;
    }


    @PostMapping("api/check-author")
    public String checkAuthor(@RequestParam int authorId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password) {
        if (validation.checkEditor(editorId, editorName, password)) {
            authorDAO.checkAuthor(editorId, authorId);
            return "Succeed";
        }
        return "FailCheckingEditor";
    }

    @PostMapping("api/decline-author")
    public String declineAuthor(@RequestParam int authorId, @RequestParam int editorId, @RequestParam String editorName, @RequestParam String password){
        if (validation.checkEditor(editorId, editorName, password)) {
            authorDAO.declineAuthor(authorId);
            return "Succeed";
        }
        return "FailCheckingEditor";
    }

}
