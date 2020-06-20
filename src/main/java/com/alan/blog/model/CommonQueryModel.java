package com.alan.blog.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonQueryModel {
    /*通用查询模板,主要用于查询博客，依据参数有：user、BlogId、获取所有的博客*/
    private User user;

    private Long blogId;

    private Map<String, String > param = new HashMap<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(long blogId) {
        this.blogId = blogId;
    }

    public Map<String, String> getParam() {
        return param;
    }

    public void setParam(Map<String, String> param) {
        this.param = param;
    }
}
