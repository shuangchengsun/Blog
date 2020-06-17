package com.alan.blog.core.model;

import com.alan.blog.Exception.UserHandlerResultException;

import java.util.HashMap;
import java.util.Map;

public class UserHandlerResult extends CommonResult{
    private String resultCode;
    private Map<String, String> param = new HashMap<>();
    private String message;

    public String getResultCode(){
        return resultCode;
    }
    public void setResultCode(String resultCode){
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addEntry(String key, String value){
        this.param.put(key,value);
    }

    public String getEntry(String key){
        if (!param.containsKey(key)){
            throw new UserHandlerResultException("do not has this param with key: "+key);
        }else{
            return param.get(key);
        }
    }
}
