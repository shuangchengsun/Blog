package com.alan.blog.service;

import com.alan.blog.model.CommonQueryModel;
import com.alan.blog.model.CommonQueryResult;

public interface CommonQueryService {

    CommonQueryResult query(CommonQueryModel queryModel);
}
