package com.yourheadline.ajaxapi;

import com.yourheadline.dao.CommentDAO;
import com.yourheadline.dao.CommentInfoDAO;
import com.yourheadline.dao.UserLikeCommentDAO;
import com.yourheadline.entity.CommentEntity;
import com.yourheadline.entity.UserLikeCommentEntity;
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
    @Autowired
    CommentInfoDAO commentInfoDAO;
    @Autowired
    UserLikeCommentDAO userLikeCommentDAO;

    @GetMapping("/comment")
    @ResponseBody
    public Map<String, Object> getAllCommentOfArticle(@RequestParam int id) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<CommentInfo> clist = commentInfoDAO.findByArticleId(id);

        map.put("comment_list", clist);

        return map;
    }

    @PostMapping("/plusLikeNumOfComment")
    @ResponseBody
    public Map<String, Object> plusLikeNumOfComment(@RequestBody Map<String,String> data) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(Integer.parseInt(data.get("commentId")));
        comment.setLikeNum(comment.getLikeNum()+1);
        commentDAO.save(comment);

        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        UserLikeCommentEntity newLike=new UserLikeCommentEntity();
        newLike.setAddTime(date);
        newLike.setCommentId(Integer.parseInt(data.get("commentId")));
        newLike.setUserId(Integer.parseInt(data.get("userId")));

        userLikeCommentDAO.save(newLike);
        map.put("comment", comment);

        return map;
    }

    @PostMapping("/minusLikeNumOfComment")
    @ResponseBody
    public Map<String, Object> minusLikeNumOfComment(@RequestBody Map<String,String> data) {
        Map<String, Object> map = new HashMap<String, Object>();

        CommentEntity comment = commentDAO.findByCommentId(Integer.parseInt(data.get("commentId")));
        comment.setLikeNum(comment.getLikeNum()-1);
        commentDAO.save(comment);

        userLikeCommentDAO.deleteByUserIdAndCommentId(Integer.parseInt(data.get("userId")),Integer.parseInt(data.get("commentId")));
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