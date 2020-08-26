package com.alan.blog.web.controller.admin;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class UserInfoController {


    /*此处采用json返回数据，在前端解析数据，然后再解析*/
    @GetMapping("/info")
    public String getInfo(HttpSession session) throws JsonProcessingException {
        return "/admin/info";
    }

}
