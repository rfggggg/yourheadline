package com.yourheadline.ajaxapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class ServletRegister {
    @PostMapping("/api/register")
    @ResponseBody
    public String doRegister(@RequestParam String userName, @RequestParam String passWord){
        System.out.println(userName);
        System.out.println(passWord);
        return "ok";
    }
}
