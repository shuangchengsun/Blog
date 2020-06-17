package com.alan.blog.dao;

import com.alan.blog.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface UserDAOService {
    public User getUserByName(String name);
    public User getUserById(Long id);
    public User getUserByNameAndPassword(String name, String password);

    public User setUser(User user);

    public User updateUser(User user);

    public void updateToken(String token, User user, String oldToken);

    public User getByToken(String Token);
}
