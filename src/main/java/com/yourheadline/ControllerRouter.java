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

    @GetMapping("/userinfo")
    public String getUserPage()
    {
        return "userinfo";
    }

    @GetMapping("/register-author")
    public String getRegisterAuthorPage() {return "register-author"; }

    @GetMapping("/new-article")
    public String getNewArticleEditor() {return "new-article"; }

    @GetMapping("/edit-article")
    public String getEditArticleEditor() {return "edit-article"; }
}
