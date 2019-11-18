package com.yourheadline.ajaxapi;


import org.springframework.web.bind.annotation.*;

@RestController
public class ServletLogin {
    @PostMapping("/api/login")
    @ResponseBody
    public String doLogin(@RequestParam String userName, @RequestParam String passWord){
        return "succeed.";
    }
}
