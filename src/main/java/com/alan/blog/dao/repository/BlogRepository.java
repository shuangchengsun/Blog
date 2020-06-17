package com.alan.blog.dao.repository;

import com.alan.blog.model.Blog;
import com.alan.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findBlogsByUser(User user);

    Blog findBlogById(Long id);

    List<Blog> findAll();


}
