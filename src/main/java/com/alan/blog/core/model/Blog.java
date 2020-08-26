package com.alan.blog.core.model;

/**
 * Blog的领域模型
 */
public class Blog {
    /**
     * 标题
     */
    String title;

    /**
     * 内容
     */
    String content;

    /**
     * 用户
     */
    User user;

    /**
     * 创建的时间
     */
    long gmt_create;

    /**
     * 更改的时间
     */
    long gmt_modify;

    /**
     * 阅览数
     */
    int views;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public long getGmt_create() {
        return gmt_create;
    }

    public long getGmt_modify() {
        return gmt_modify;
    }

    public int getViews() {
        return views;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGmt_create(long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public void setGmt_modify(long gmt_modify) {
        this.gmt_modify = gmt_modify;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
