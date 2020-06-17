package com.alan.blog.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;


    private String title;               //此处是博客标题
    private String content;             //此处是博客正文
    private String labelPicture;        //此处标志首页图链接
    private String flag;                //原创、转载、翻译或其他
    private Integer views;              //此处标志浏览次数
    private boolean appreciation;       //此处标志了是否开启赞赏开关
    private boolean share;              //此处标志是否允许转载
    private boolean commentable;        //此处标志是否允许评价
    private boolean published;          //此处标志是否已经发表
    private boolean recommend;          //此处标志是否推荐
    private String summery;             //摘要
    private String createTime;            //此处标志创建时间
    private String updateTime;            //此处标志最后更新时间

    @ManyToOne
    private Type type;                  //此处标志分类

    @ManyToMany(cascade = {CascadeType.PERSIST})

    @JsonIgnore
    private List<Tag> tags = new ArrayList<>(); //此处是标签列表

    @ManyToOne
    private User user;                  //此处标志作者

    @OneToMany(mappedBy = "blog")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>(); //评论列表

    public Blog() {
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabelPicture() {
        return labelPicture;
    }

    public void setLabelPicture(String labelPicture) {
        this.labelPicture = labelPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }



    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", labelPicture='" + labelPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", share=" + share +
                ", commentable=" + commentable +
                ", published=" + published +
                ", recommend=" + recommend +
                ", summery='" + summery + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                '}';
    }
}
