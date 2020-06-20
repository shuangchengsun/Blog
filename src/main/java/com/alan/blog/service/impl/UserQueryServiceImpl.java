package com.alan.blog.service.impl;

import com.alan.blog.dao.UserDAOService;
import com.alan.blog.model.CommonQueryModel;
import com.alan.blog.model.CommonQueryResult;
import com.alan.blog.service.CommonQueryService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserQueryServiceImpl implements CommonQueryService {

    @Autowired
    private UserDAOService userDAOService;
    @Override
    public CommonQueryResult query(CommonQueryModel queryModel) {
        return null;
    }
}
