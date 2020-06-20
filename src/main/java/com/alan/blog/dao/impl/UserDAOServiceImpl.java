package com.alan.blog.dao.impl;

import com.alan.blog.Exception.RedisException;
import com.alan.blog.dao.UserDAOService;
import com.alan.blog.dao.redis.RedisClient;
import com.alan.blog.dao.repository.UserRepository;
import com.alan.blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAOServiceImpl implements UserDAOService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserDAOServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisClient redisClient;


    @Override
    public User getUserByName(String name) {
        User user = null;
        user = userRepository.findByUserName(name);
        if (user == null) {
            LOGGER.error("get user from redis and dataBase both error");
        }
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = null;
        user = userRepository.getOne(id);
        if (user == null) {
            LOGGER.error("get user from dataBase error, user may not exist!!!");
        }
        return user;
    }

    @Override
    public User getUserByNameAndPassword(String name, String password) {
        User user = null;
        user = userRepository.findByUserNameAndPassword(name, password);
        if (user == null) {
            LOGGER.error("find user by name and password error, user may not exist!");
        }
        return user;
    }

    @Override
    public User setUser(User user) {
        /*写数据库*/
        userRepository.save(user);
        /*写缓存*/
        boolean b = redisClient.setObject(user.getToken(), user);
        if (!b) {
            LOGGER.info("write to redis error, may caused by repeated token");
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void updateToken(String token, User user, String oldToken) {

        if (redisClient.removeKey(oldToken)&&
                redisClient.removeKeyFromSet("token", oldToken) &&
                redisClient.setObject(token, user) &&
                redisClient.setMembers("token", token)) {
        } else {
            throw new RedisException("updateToken error");
        }


    }

    @Override
    public User getByToken(String token) {
        User user = null;
        try {
            user = (User) redisClient.getObject(token, User.class);
            if (user == null) {
                /*数据不在redis中，去数据库拿*/
                user = userRepository.findByToken(token);
                if (user == null) {
                    /*压根没有这个user*/
                    LOGGER.error("user with token: " + token + " is not exist!");
                } else {
                    /*拿到了，写回redis*/
                    redisClient.setObject(token, user);
                }
            }
        } catch (Exception exception) {
            LOGGER.error(exception.getMessage());
        }
        return user;
    }


    @Override
    public void deleteUser(User user) {

    }
}
