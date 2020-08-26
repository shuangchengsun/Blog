package com.alan.blog.web.controller.admin;


import com.alan.blog.model.Blog;
import com.alan.blog.model.Tag;
import com.alan.blog.model.Type;
import com.alan.blog.model.User;
import com.alan.blog.service.BlogService;
import com.alan.blog.service.TagService;
import com.alan.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class ModifyController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("publish")
    public String getPublishPage(Model model) {
        List<Type> typeList = typeService.getAllType();
        model.addAttribute("typeList", typeList);
        List<Tag> tagList = tagService.getAll();
        model.addAttribute("tagList", tagList);
        model.addAttribute("blog", new Blog());
        return "admin/publish";

    }

    @PostMapping("publish")
    public String publishBlog(Blog blog,
                              HttpSession session,
                              RedirectAttributes attributes) {
        User currentUser = (User) session.getAttribute("user");
        blog.setUser(currentUser);
        String date = new SimpleDateFormat("yyy-MM-dd").format(new Date()).toString();
        blog.setCreateTime(date);
        blog.setUpdateTime(date);
        blog.setComments(null);
        blog.setViews(0);
        if(blog.getLabelPicture() == null || blog.getLabelPicture().length()==0){
            blog.setLabelPicture("https://unsplash.it/100/100?image=1005");
        }

        Blog blog1 = blogService.saveBlog(blog);
        if(blog1 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "index";
    }

    /*用于修改博客内容*/
    @GetMapping("/modify")
    public String getModifyPage(@RequestParam(name = "id") Long id,
                                Model model){
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        List<Type> typeList = typeService.getAllType();
        model.addAttribute("typeList", typeList);
        List<Tag> tagList = tagService.getAll();
        model.addAttribute("tagList", tagList);
        return "/admin/publish";
    }

    @PostMapping("/modify")
    public String putModifyMessage(Blog blog,
                                   HttpSession session,
                                   RedirectAttributes attributes){
        User currentUser = (User) session.getAttribute("user");
        blog.setUser(currentUser);
        String date = new SimpleDateFormat("yyy-MM-dd").format(new Date()).toString();
        blog.setCreateTime(date);
        blog.setUpdateTime(date);
        blog.setComments(null);
        blog.setViews(0);
        if(blog.getLabelPicture() == null || blog.getLabelPicture().length()==0){
            blog.setLabelPicture("https://unsplash.it/100/100?image=1005");
        }

        Blog blog1 = blogService.saveBlog(blog);
        if(blog1 == null){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "index";

    }
}
