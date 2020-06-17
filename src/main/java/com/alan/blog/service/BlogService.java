package com.alan.blog.service;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;

import java.util.List;

public interface BlogService {

    Blog saveBlog(Blog blog);

    List<Blog> getBlogsByUser(User user);

    Blog getBlogById(Long id);

    List<Blog> listBlog();

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}
