package com.yourheadline.ajaxapi;

import com.yourheadline.dao.CommentDAO;
import com.yourheadline.entity.CommentEntity;
import com.yourheadline.model.CommentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}