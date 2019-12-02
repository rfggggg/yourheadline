package com.yourheadline.ajaxapi;

import com.yourheadline.dao.CommentDAO;
import com.yourheadline.dao.UserLikeCommentDAO;
import com.yourheadline.entity.CommentEntity;
import com.yourheadline.model.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletComment {

    @Autowired
    CommentDAO commentDAO;

    @GetMapping("/comment")
    @ResponseBody
    public Map<String, Object> getAllCommentOfArticle(@RequestParam int id) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<CommentInfo> clist = commentDAO.findByArticleId(id);

        map.put("comment_list", clist);

        return map;
    }

    @GetMapping("/plusLikeNumOfComment")
    @ResponseBody
    public Map<String, Object> plusLikeNumOfComment(@RequestParam int id) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(id);
        comment.setLikeNum(comment.getLikeNum()+1);
        commentDAO.save(comment);
        map.put("comment", comment);

        return map;
    }

    @GetMapping("/minusLikeNumOfComment")
    @ResponseBody
    public Map<String, Object> minusLikeNumOfComment(@RequestParam int id) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(id);
        comment.setLikeNum(comment.getLikeNum()-1);
        commentDAO.save(comment);
        map.put("comment", comment);

        return map;
    }

    @PostMapping("/addNewComment")
    @ResponseBody
    public Map<String, Object> addNewComment(@RequestBody Map<String,String> data) {

        Map<String, Object> map = new HashMap<String, Object>();
        CommentEntity newComment = new CommentEntity();
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        newComment.setAddTime(date);
        newComment.setContent(data.get("content"));
        newComment.setLikeNum(0);
        newComment.setArticleId(Integer.parseInt(data.get("articleId")));
        newComment.setUserId(Integer.parseInt(data.get("userId")));
        commentDAO.save(newComment);
        map.put("comment", newComment);

        return map;
    }
}