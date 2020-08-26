package com.alan.blog.web.controller;

import com.alan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping({"/"})
    public String index(HttpServletRequest request, HttpServletResponse response){
        /*检查cookie中是否包含登录信息*/
        userService.checkLogin(request, response);
        return "index";
    }
}
