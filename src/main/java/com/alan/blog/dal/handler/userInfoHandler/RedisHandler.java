package com.alan.blog.dal.handler.userInfoHandler;

import com.alan.blog.core.model.CommonParam;
import com.alan.blog.core.model.CommonResult;
import com.alan.blog.core.model.UserHandlerResult;
import com.alan.blog.core.model.UserInfo;
import com.alan.blog.dal.handler.Handler;

import java.util.Map;

public class RedisHandler implements Handler {
    @Override
    public void run(CommonParam param, CommonResult commonResult) {
        UserInfo info = (UserInfo)param;
        UserHandlerResult result = (UserHandlerResult) commonResult;

        Map<String, String> map = info.getParams();

    }
}
