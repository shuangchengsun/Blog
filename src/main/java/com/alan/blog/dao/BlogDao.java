package com.alan.blog.dao;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BlogDao {

    Blog getById(Long id);

    List<Blog> getByUser(User user);

    List<Blog> getAll();

    List<Blog> getAll(Integer page, Integer offset);

}
