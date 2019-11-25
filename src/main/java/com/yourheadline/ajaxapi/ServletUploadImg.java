package com.yourheadline.ajaxapi;


import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServletUploadImg {

    @Autowired
    private Validation validation;

    @Value("${localStaticPath}")
    private String localStaticPath;

    @Value("${localPathDelimiter}")
    private String delimiter;

    @PostMapping("/upload-article-img")
    public Map<String, Object> upLoadArticleImg(@RequestParam("img") List<MultipartFile> imgList,
                                                @RequestParam int articleId,
                                                @RequestParam String authorName,
                                                @RequestParam String passWord)
    {
        Map<String, Object> map = new HashMap<>();
        int error = 0;
        List<String> dataList = new ArrayList<>();

        String localRoot = localStaticPath + delimiter + authorName + delimiter + articleId + delimiter;
        String httpRoot = '/' + authorName + '/' + articleId + '/';

        Path p = Paths.get(localRoot);
        try {
            Files.createDirectories(p);
        } catch (IOException e) {
            e.printStackTrace();
            error = 1;
        }

        int index = (new File(localRoot)).list().length;
        System.out.println(index);
        if (validation.checkAuthor(authorName, passWord)) {
            for (int i = 0; i < imgList.size(); i++){
                MultipartFile httpFile = imgList.get(i);
                String originalFileName = httpFile.getOriginalFilename();
                String extensionName = originalFileName.substring(originalFileName.lastIndexOf("."));

                String localEntirePath = localRoot + delimiter + (i + index) + extensionName;
                String httpEntirePath = httpRoot + (i + index) + extensionName;
                File file = new File(localEntirePath);
                try {
                    httpFile.transferTo(file);
                    dataList.add(httpEntirePath);
                } catch (IOException e) {
                    e.printStackTrace();
                    error = 2;
                }
            }

        }

        map.put("errno", error);
        map.put("data", dataList);
        return map;
    }
}
