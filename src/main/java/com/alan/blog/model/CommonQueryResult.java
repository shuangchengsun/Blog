package com.alan.blog.model;

import java.util.*;

public class CommonQueryResult {

    CommonQueryModel commonQueryModel;
    Boolean success;
    Integer errorCode;
    String message;
    Map<String, String> param = new HashMap<>();
    List<Object> result = new LinkedList<>();

    public CommonQueryModel getCommonQueryModel() {
        return commonQueryModel;
    }

    public void setCommonQueryModel(CommonQueryModel commonQueryModel) {
        this.commonQueryModel = commonQueryModel;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map param) {
        this.param = param;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}
