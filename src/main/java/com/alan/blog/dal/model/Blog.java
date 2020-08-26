package com.alan.blog.dal.model;


import java.sql.Date;

/**
 * 数据库中的模型
 */
public class Blog {

    /**
     * 主键
     */
    long id;

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
    long userId;

    /**
     * 创建的时间
     */
    Date gmt_create;

    /**
     * 修改的时间
     */
    Date gmt_modify;

    /**
     * 阅读数
     */
    int views;

    /**
     * 标签
     */
    long tagId;

    /**
     * 分类
     */
    long typeId;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public long getUserId() {
        return userId;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public Date getGmt_modify() {
        return gmt_modify;
    }

    public int getViews() {
        return views;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public void setGmt_modify(Date gmt_modify) {
        this.gmt_modify = gmt_modify;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", gmt_create=" + gmt_create +
                ", gmt_modify=" + gmt_modify +
                ", views=" + views +
                '}';
    }
}
