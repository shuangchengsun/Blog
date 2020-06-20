package com.alan.blog.service;

import com.alan.blog.model.Blog;
import com.alan.blog.model.CommonQueryModel;
import com.alan.blog.model.CommonQueryResult;
import com.alan.blog.model.User;

import java.util.List;

public interface BlogService {

    /*保存blog*/
    Blog saveBlog(Blog blog);

    /**/
    List<Blog> getBlogsByUser(User user);

    Blog getBlogById(Long id);

    List<Blog> listBlog();

    CommonQueryResult getBlog(CommonQueryModel queryModel);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}
