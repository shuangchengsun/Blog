package com.alan.blog.service.impl;

import com.alan.blog.dao.repository.TypeRepository;
import com.alan.blog.model.Type;
import com.alan.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typerepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typerepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(long id) {
        return null;
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return null;
    }

    @Transactional
    @Override
    public Type updateType(long id, Type type) {
        return null;
    }

    @Transactional
    @Override
    public void deleteType(long id) {

    }

    @Override
    public List<Type> getAllType() {
        List<Type> typeList = new ArrayList<>();
        typeList = typerepository.findAll();
        return typeList;
    }
}
