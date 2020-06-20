package com.alan.blog.model;

public enum QueryErrorCode {

    ParamError(0x01, "参数错误，检查传入的user和id是否为空"),
    ParamIllegal(0x02,"参数非法"),
    QueryFailed(0x03,"查询失败"),
    OtherError(0x04,"未知错误")

    ;

    private Integer errorCode;
    private String errormessage;

    private QueryErrorCode(Integer code, String message){
        this.errorCode=code;
        this.errormessage=message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
