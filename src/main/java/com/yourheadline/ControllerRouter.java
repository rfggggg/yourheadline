package com.yourheadline;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerRouter {
    @GetMapping("/")
    public String getIndexPage()
    {
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage()
    {
        return "register";
    }

    @GetMapping("/article")
    public String getArticlePage()
    {
        return "article";
    }

    @GetMapping("/register-author")
    public String getRegisterAuthorPage() {return "register-author"; }

    @GetMapping("/new-article")
    public String getNewArticleEditor() {return "new-article"; }

    @GetMapping("/edit-article")
    public String getEditArticleEditor() {return "edit-article"; }

    @GetMapping("/unchecked-article")
    public String getEditorPage() {return "unchecked-article"; }
}
