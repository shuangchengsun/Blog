package com.alan.blog.handler;

import com.alan.blog.core.model.CommonParam;
import com.alan.blog.core.model.CommonResult;

public interface Handler {
    public void run(CommonParam param, CommonResult result);
}
