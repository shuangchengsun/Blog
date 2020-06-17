package com.alan.blog.core.model;

import com.alan.blog.handler.Handler;
import com.alan.blog.model.User;

import java.util.List;

public class userInfoContext {
    private UserInfo userInfo;
    private List<Handler> handlerList;
    private User user;
    private UserHandlerResult result;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Handler> getHandlerList() {
        return handlerList;
    }

    public void setHandlerList(List<Handler> handlerList) {
        this.handlerList = handlerList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserHandlerResult getResult() {
        return result;
    }

    public void setResult(UserHandlerResult result) {
        this.result = result;
    }
}
