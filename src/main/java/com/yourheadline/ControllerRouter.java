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
    public String getAuthorPage()
    {
        return "register";
    }
}
