package com.alan.blog.controller.admin;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;
import com.alan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class index {

    @Autowired
    BlogService blogService;

    @GetMapping({"/index"})
    public String index(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<Blog> blogList = blogService.getBlogsByUser(user);
        model.addAttribute("blogList", blogList);
        return "/admin/index";

    }

}
