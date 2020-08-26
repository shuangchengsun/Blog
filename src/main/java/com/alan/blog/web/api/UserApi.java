package com.alan.blog.web.api;

import com.alan.blog.model.User;
import com.alan.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/api/user")
@Controller
public class UserApi {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/info")
    public String getUserInfo(HttpSession session) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = (User) session.getAttribute("user");
        return mapper.writeValueAsString(user);
    }

    @ResponseBody
    @GetMapping("/test")
    public String getUserInfo() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = userService.getTestUser();
        return mapper.writeValueAsString(user);
    }

}
