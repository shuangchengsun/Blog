package com.alan.blog.service;

import com.alan.blog.model.CommonQueryModel;
import com.alan.blog.model.CommonQueryResult;
import com.alan.blog.model.QueryErrorCode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class CommonQueryManager {

    private Map<String,CommonQueryService> serviceMap;



    public CommonQueryResult handle(CommonQueryModel queryModel) {
        if(!paramCheck(queryModel)){
            CommonQueryResult result = new CommonQueryResult();
            result.setSuccess(false);
            result.setResult(null);
            result.setParam(null);
            result.setCommonQueryModel(queryModel);
            result.setMessage(QueryErrorCode.ParamIllegal.getErrormessage());
            result.setErrorCode(QueryErrorCode.ParamIllegal.getErrorCode());
            return result;
        }
        String type = getQueryType(queryModel);
        CommonQueryService service = serviceMap.get(type);
        return service.query(queryModel);
    }

    private boolean paramCheck(CommonQueryModel queryModel) {
        Map<String,String> param = queryModel.getParam();
        if(param == null || param.size() == 0) {
            return false;
        }
        return param.containsKey("queryType");
    }

    private String getQueryType(CommonQueryModel model){
        /*辨别是什么*/
        Map<String,String> param = model.getParam();
        return param.get("queryType");
    }


    public void setServiceMap(Map<String, CommonQueryService> map){
        this.serviceMap = map;
    }
}
