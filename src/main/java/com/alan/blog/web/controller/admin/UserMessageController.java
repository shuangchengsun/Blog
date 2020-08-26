package com.alan.blog.web.controller.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class UserMessageController {

    @GetMapping("/message")
    public String getMessage(){
        return null;
    }

}
