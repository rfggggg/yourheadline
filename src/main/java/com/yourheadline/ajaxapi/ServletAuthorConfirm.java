package com.yourheadline.ajaxapi;


import com.yourheadline.entity.AuthorEntity;
import com.yourheadline.model.AuthorDAO;
import com.yourheadline.service.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
public class ServletAuthorConfirm {
    @Autowired
    Validation validation;
    @Autowired
    AuthorDAO authorDAO;

    @PostMapping("/api/author-confirm")
    public Map<String, Object> acceptAuthorConfirm(Integer authorId,
                                             String authorName,
                                             String password,
                                             String idCardBack,
                                             String idCardFront,
                                             String applyText)
    {
        if (!validation.checkAuthor(authorId, authorName, password)) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        String status = "Fail";
        List<AuthorEntity> auList = authorDAO.findByAuthorId(authorId);

        AuthorEntity aue = null;
        if (auList.isEmpty()){
            aue = new AuthorEntity();
        }
        else{
            aue = auList.get(0);
        }
        aue.setIdCardBack(idCardBack);
        aue.setIdCardFront(idCardFront);
        aue.setApplyText(applyText);

        map.put("status", status);
        return map;
    }

}
