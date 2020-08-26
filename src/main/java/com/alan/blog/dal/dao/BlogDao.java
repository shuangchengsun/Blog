package com.alan.blog.dal.dao;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;

import java.util.List;

public interface BlogDao {

    Blog getById(Long id);

    List<Blog> getByUser(User user);

    List<Blog> getAll();

    List<Blog> getAll(Integer page, Integer offset);

}
