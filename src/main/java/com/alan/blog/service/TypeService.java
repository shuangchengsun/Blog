package com.alan.blog.service;

import com.alan.blog.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    Type saveType(Type type);

    Type getType(long id);

    Page<Type> listType(Pageable pageable);

    List<Type> getAllType();
    /*修改*/
    Type updateType(long id, Type type);

    void deleteType(long id);
}
