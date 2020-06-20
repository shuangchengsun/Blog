package com.alan.blog.dao;

import com.alan.blog.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface UserDAOService {
    /*从名字获取*/
    public User getUserByName(String name);

    /*从id获取*/
    public User getUserById(Long id);

    /*校验name 和 password*/
    public User getUserByNameAndPassword(String name, String password);

    /*存储一个user*/
    public User setUser(User user);

    /*更新一个user*/
    public User updateUser(User user);

    /*更新token,token没有强一致性需求*/
    public void updateToken(String token, User user, String oldToken);

    /*从token获取user*/
    public User getByToken(String Token);

    /*删除user*/
    public void deleteUser(User user);

}
