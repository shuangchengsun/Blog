package com.alan.blog.web.controller;


import com.alan.blog.model.Blog;
import com.alan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowBlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/show")
    public String showBlog(@RequestParam(name = "id") Long id,
                           Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "blog";
    }
}
