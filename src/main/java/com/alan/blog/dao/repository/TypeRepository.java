package com.alan.blog.dao.repository;

import com.alan.blog.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository  extends JpaRepository<Type, Long> {
}
