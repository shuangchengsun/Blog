package com.alan.blog.dal.dao.repository;

import com.alan.blog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository  extends JpaRepository<Type, Long> {
}
