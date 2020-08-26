package com.alan.blog.web.controller.admin;


import com.alan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin")
@Controller
public class DeleteController {

    @Autowired
    BlogService blogService;

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam(name = "id") Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/index";
    }
}
