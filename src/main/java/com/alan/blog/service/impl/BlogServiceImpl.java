package com.alan.blog.service.impl;

import com.alan.blog.dao.repository.BlogRepository;
import com.alan.blog.model.Blog;
import com.alan.blog.model.User;
import com.alan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;


    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public List<Blog> getBlogsByUser(User user) {
        return blogRepository.findBlogsByUser(user);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findBlogById(id);
    }

    @Override
    public List<Blog> listBlog() {
        return blogRepository.findAll();
    }
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        return null;
    }

    @Override
    public void deleteBlog(Long id) {

    }
}
