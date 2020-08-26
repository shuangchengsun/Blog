package com.alan.blog.dal.dao.repository;

import com.alan.blog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

}
