package com.yourheadline.ajaxapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServletHomeArticle {
    @GetMapping("/article/home")
    @ResponseBody
    public String getData(){
        return " {\"article_list\":" +
                "[" +
                "{\"id\":1,\"text\":\"<p>这是主页文章条条1</p>\",\"author_name\":\"a1\",\"publish_time\":\"1:00\"}," +
                "{\"id\":2,\"text\":\"<p>这是主页文章条条2</p>\",\"author_name\":\"a2\",\"publish_time\":\"2:00\"}," +
                "{\"id\":2,\"text\":\"<p>这是主页文章条条3</p>\",\"author_name\":\"a2\",\"publish_time\":\"2:00\"}" +
                "]}";
    }
}
