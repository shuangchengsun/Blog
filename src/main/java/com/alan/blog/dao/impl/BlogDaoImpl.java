package com.alan.blog.dao.impl;

import com.alan.blog.core.model.BlogCache;
import com.alan.blog.dao.BlogDao;
import com.alan.blog.dao.repository.BlogRepository;
import com.alan.blog.model.Blog;
import com.alan.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogDaoImpl implements BlogDao {

    private BlogCache blogCache = BlogCache.getInstance();

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog getById(Long id) {
        Blog blog = blogCache.getBlog(id);
        if(blog == null){
            blog = blogRepository.findBlogById(id);
            blogCache.setBlog(blog);
            return blog;
        }
        return blog;
    }

    @Override
    public List<Blog> getByUser(User user) {
        return blogRepository.findBlogsByUser(user);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> getAll(Integer page, Integer offset) {

        return null;
    }
}
