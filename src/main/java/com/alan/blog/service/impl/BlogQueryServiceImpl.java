package com.alan.blog.service.impl;

import com.alan.blog.dao.BlogDao;
import com.alan.blog.model.*;
import com.alan.blog.service.CommonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlogQueryServiceImpl implements CommonQueryService {

    @Autowired
    private BlogDao blogDao;


    @Override
    public CommonQueryResult query(CommonQueryModel queryModel) {
        CommonQueryResult result = new CommonQueryResult();
        result.setCommonQueryModel(queryModel);
        /*如果博客id不为空，那么就按照博客id查找*/
        if (!checkParam(queryModel)) {
            /*鉴权失败*/
            buildErrorResult(QueryErrorCode.ParamError,result);
            return result;
        }
        if (queryModel.getBlogId() != null) {
            /*此时按照BlogId查询*/
            Blog blog = blogDao.getById(queryModel.getBlogId());
            if (blog != null) {
                List list = new LinkedList<>();
                list.add(blog);
                Map<String, String> map = new HashMap<>();
                map.put("length", "1");
                result.setSuccess(true);
                result.setMessage("Query Success! the result length is 1");
                result.setParam(map);
                result.setResult(list);
                return result;
            }
        }
        if (queryModel.getUser() != null) {
            User user = queryModel.getUser();
            List blogs = blogDao.getByUser(user);
            Map<String, String> map = new HashMap<>();
            map.put("length", String.valueOf(blogs.size()));
            result.setSuccess(true);
            result.setMessage("Query Success! the result length is " + blogs.size());
            result.setParam(map);
            result.setResult(blogs);
            return result;
        }

        Map<String, String> map = queryModel.getParam();
        if(map.containsKey("limit") && map.containsKey("offset")){
            Integer limit = Integer.valueOf(map.get("limit"));
            Integer offset = Integer.valueOf(map.get("offset"));
            List blogs = blogDao.getAll(limit,offset);
            Map<String,String> map1 = new HashMap();
            map1.put("length", String.valueOf(blogs.size()));
            result.setSuccess(true);
            result.setParam(map1);
            result.setMessage("Query Success! the result length is " + blogs.size());
            result.setResult(blogs);
        }else {
            buildErrorResult(QueryErrorCode.ParamIllegal,result);
            return result;
        }
        buildErrorResult(QueryErrorCode.OtherError,result);
        return result;
    }

    private boolean checkParam(CommonQueryModel model) {
        return !(model.getBlogId() == null && model.getUser() == null);
    }
    private void buildErrorResult(QueryErrorCode errorCode,CommonQueryResult result){
        result.setSuccess(false);
        result.setErrorCode(errorCode.getErrorCode());
        result.setMessage(errorCode.getErrormessage());
        result.setParam(null);
        result.setResult(null);
    }
}
