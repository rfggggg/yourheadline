package com.yourheadline.ajaxapi;

import com.yourheadline.dao.ArticleDAO;
import com.yourheadline.dao.ArticleInfoDAO;
import com.yourheadline.entity.ArticleEntity;
import com.yourheadline.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ServletArticleHome {
    //    @Autowired
//    ArticleDAO articleDAO;
    @Autowired
    ArticleInfoDAO articleInfoDAO;
    @Autowired
    ArticleDAO articleDAO;

    @GetMapping("/article/home")
    @ResponseBody
    public Map<String, Object> getData() {

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleInfo> aiList = articleInfoDAO.findAll();

//        老的用法，用@OneToMany和@ManyToOne的方法，注释掉不要了
//        List<ArticleEntity> aList = articleDAO.findAll();
//        List<ArticleInfo> aiList = new ArrayList<ArticleInfo>();
//
//        for (ArticleEntity a: aList){
//            ArticleInfo ai = new ArticleInfo();
//            ai.articleId = a.getArticleId();
//            ai.authorId = a.getAuthorId();
//            ai.editorId = a.getEditorId();
//            ai.moduleId = a.getModuleId();
//            ai.articleTitle = a.getArticleTitle();
//            ai.articleText = a.getArticleText();
//            ai.addTime = a.getAddTime();
//            ai.likeNum = a.getLikeNum();
//
//            ai.authorName = a.getAuthor().getAuthorName();
//            ai.editorName = "sb";
//
//            aiList.add(ai);
//        }
        map.put("article_list", aiList);

        return map;
    }

    @GetMapping("/article/module")
    @ResponseBody
    public Map<String, Object> findModuleid(@RequestParam int id) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleInfo> mlist = articleInfoDAO.findArticleInfoByModuleId(id);

        map.put("article_list", mlist);

        return map;
    }

    @GetMapping("/article/collect")
    @ResponseBody
    public Map<String, Object> findArticleid(@RequestParam int id) {

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleInfo> article = articleInfoDAO.selectCollectionByUserId(id);
        map.put("article_list", article);

        return map;
    }

    @GetMapping("/article/detail")
    @ResponseBody
    public  Map<String, Object> findArticle(@RequestParam int id){

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleInfo> aList = articleInfoDAO.findArticleInfoByArticleId(id);

            map.put("article_list", aList);
            return map;

    }

    @PostMapping("/article/authorpage")
    @ResponseBody
    public  Map<String, Object> findarticlebyauthor(@RequestBody Map<String, String> inMap){

        Map<String, Object> map = new HashMap<String, Object>();

        if (inMap.containsKey("authorId")) {
            int authorId = Integer.parseInt(inMap.get("authorId"));

            List<ArticleEntity> aList = new ArrayList<>();
            aList=articleDAO.findByAuthorId(authorId);
            if (aList.isEmpty()){
                return null;
            }
            else {
                map.put("article_list", aList);
                return map;
            }
        }
        return  null;
    }
}