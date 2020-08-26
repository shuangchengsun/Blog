package com.alan.blog.service.impl;

import com.alan.blog.dal.dao.repository.BlogRepository;
import com.alan.blog.model.*;
import com.alan.blog.service.BlogService;
import com.alan.blog.service.CommonQueryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    CommonQueryManager manager;


    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Deprecated
    @Override
    public List<Blog> getBlogsByUser(User user) {
        return blogRepository.findBlogsByUser(user);
    }

    @Deprecated
    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findBlogById(id);
    }

    @Deprecated
    @Override
    public List<Blog> listBlog() {
        return blogRepository.findAll();
    }

    @Override
    public CommonQueryResult getBlog(CommonQueryModel queryModel) {
        return manager.handle(queryModel);
    }



    @Override
    public Blog updateBlog(Long id, Blog blog) {
        return null;
    }

    @Override
    public void deleteBlog(Long id) {

    }
}
