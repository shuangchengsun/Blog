package com.alan.blog.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户的领域模型
 */
public class User {
    /**
     * 用户名
     */
    String userName;

    /**
     * 密码
     */
    @JsonIgnore
    String passWord;

    /**
     * 昵称
     */
    String nickName;

    /**
     * 头像链接
     */
    String avatar;

    /**
     * 用户的email
     */
    String email;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
