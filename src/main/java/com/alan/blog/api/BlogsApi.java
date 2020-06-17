package com.alan.blog.api;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;
import com.alan.blog.service.BlogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/api/blog")
@Controller
public class BlogsApi {


    @Autowired
    BlogService blogService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ResponseBody
    @GetMapping("/getOne")
    public String getBlogContent(@RequestParam("id") Long id) {
        if(id == null){
            return null;
        }
        Blog blog = blogService.getBlogById(id);
        ObjectMapper mapper = new ObjectMapper();
        if(blog == null){
            return null;
        }else
            try {
                return mapper.writeValueAsString(blog);
            }catch (JsonProcessingException e){
                e.printStackTrace();
            }finally {
                return null;
        }
    }

    @ResponseBody
    @GetMapping("/getAll")
    public String getAllBlog(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Blog> blogList = blogService.getBlogsByUser(user);
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(blogList);
        } catch (JsonProcessingException e) {
            logger.error("get blogs failed");
            e.printStackTrace();
            return "[]";
        }
    }

    @ResponseBody
    @GetMapping("/all")
    public String getAllBlogWithoutUser(){
        List<Blog> blogList = blogService.listBlog();
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(blogList);
        } catch (JsonProcessingException e) {
            logger.error("get blogs failed");
            e.printStackTrace();
            return "[]";
        }
    }
}
