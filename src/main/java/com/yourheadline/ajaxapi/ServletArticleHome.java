package com.yourheadline.ajaxapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.yourheadline.entity.*;
import java.sql.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ServletArticleHome {
    @GetMapping("/article/home")
    @ResponseBody
    public Map<String, Object> getData(){
        String url="jdbc:mysql://localhost:3306/yourheadline?autoReconnect=true&useUnicode=true&createDatabaseIfNotExist=true&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Shanghai";

        Map<String, Object> map = new HashMap<String, Object>();

        List<ArticleEntity> alist = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c= DriverManager.getConnection(url, "root", "mysql");

            String sql = "select * from article";
            PreparedStatement stmt=c.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ArticleEntity ae = new ArticleEntity();
                ae.setArticleId(rs.getInt("article_id"));
                ae.setArticleTitle(rs.getString("article_title"));
                ae.setArticleText(rs.getString("article_text"));
                ae.setAuthorId(rs.getInt("author_id"));
                ae.setEditorId(rs.getInt("editor_id"));
                ae.setAddTime(rs.getDate("add_time"));
                alist.add(ae);
            }
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        map.put("article_list", alist);

        // String bak="{\"article_list\":" +
        //                "[" +
        //                "{\"id\":1,\"text\":\"<p>这是主页文章条条1</p>\",\"author_name\":\"a1\",\"publish_time\":\"1:00\"}," +
        //                "{\"id\":2,\"text\":\"<p>这是主页文章条条2</p>\",\"author_name\":\"a2\",\"publish_time\":\"2:00\"}," +
        //                "{\"id\":2,\"text\":\"<p>这是主页文章条条3</p>\",\"author_name\":\"a2\",\"publish_time\":\"2:00\"}" +
        //                "]}";
        // return bak;

        return map;

    }
}
