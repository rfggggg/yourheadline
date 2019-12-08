package com.yourheadline.ajaxapi;

import com.yourheadline.dao.CommentDAO;
import com.yourheadline.dao.CommentInfoDAO;
import com.yourheadline.dao.UserLikeCommentDAO;
import com.yourheadline.entity.CommentEntity;
import com.yourheadline.entity.UserLikeCommentEntity;
import com.yourheadline.model.CommentInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ServletUserComment {

    @Autowired
    CommentDAO commentDAO;
    @Autowired
    CommentInfoDAO commentInfoDAO;
    @Autowired
    UserLikeCommentDAO userLikeCommentDAO;



    @GetMapping("/api/do-like-comment")
    @ResponseBody
    public Map<String, Object> doLikeComment(@RequestParam int commentId, @RequestParam int userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(commentId);
        comment.setLikeNum(comment.getLikeNum()+1);
        commentDAO.save(comment);

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        UserLikeCommentEntity newLike=new UserLikeCommentEntity();
        newLike.setAddTime(date);
        newLike.setCommentId(commentId);
        newLike.setUserId(userId);

        userLikeCommentDAO.save(newLike);
        map.put("status", "OK");

        return map;
    }

    @GetMapping("/api/cancel-like-comment")
    @ResponseBody
    public Map<String, Object> cancelLikeComment(@RequestParam int commentId, @RequestParam int userId) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(commentId);
        comment.setLikeNum(comment.getLikeNum()-1);
        commentDAO.save(comment);

        userLikeCommentDAO.deleteByUserIdAndCommentId(userId, commentId);
        map.put("status", "OK");

        return map;
    }

    @GetMapping("/api/add-comment")
    @ResponseBody
    public Map<String, Object> addNewComment(@RequestParam int articleId, @RequestParam int userId, @RequestParam String content) {

        Map<String, Object> map = new HashMap<String, Object>();
        CommentEntity newComment = new CommentEntity();
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        newComment.setAddTime(date);
        newComment.setContent(content);
        newComment.setLikeNum(0);
        newComment.setArticleId(articleId);
        newComment.setUserId(userId);
        commentDAO.save(newComment);
        map.put("status", "OK");

        return map;
    }
}