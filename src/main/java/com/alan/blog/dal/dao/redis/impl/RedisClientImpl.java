package com.alan.blog.dal.dao.redis.impl;

import com.alan.blog.Exception.RedisObjectNotFoundException;
import com.alan.blog.dal.dao.redis.RedisClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RedisClientImpl implements RedisClient {
    private final static Logger LOGGER = LoggerFactory.getLogger(RedisClientImpl.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Object getObject(String key, Class instanceType) {
        try {
            LOGGER.info("get message from redis by " + key);
            String objString = redisTemplate.opsForValue().get(key);
            if(objString == null ){
                return null;
            }
            ObjectMapper mapper = new ObjectMapper();
            Object object = mapper.readValue(objString, instanceType);
            return object;
        } catch (JsonProcessingException exception) {
            LOGGER.error(exception.getMessage());
            return null;
        }
    }

    @Override
    public boolean setObject(String key, Object value) {
        try {
            if(redisTemplate.hasKey(key)){
                return false;
            }
            ObjectMapper mapper = new ObjectMapper();
            String objectString = mapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, objectString);
            LOGGER.info("insert into redis-service key: " + key);
            return true;
        } catch (JsonProcessingException exception) {
            LOGGER.error(exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean setMembers(String key, String... strings) {
        boolean flag = true;
        for (String string : strings) {
            Long l = redisTemplate.opsForSet().add(key, string);
            flag = flag && (l != null && l > 0);
        }
        return flag;
    }

    @Override
    public Set<String> getMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Deprecated
    @Override
    public boolean removeKey(String key) {
        Boolean flag = redisTemplate.hasKey(key);
        if(flag != null && !flag){
            return true;
        }
        Boolean delete = redisTemplate.delete(key);
        return delete != null && delete;
    }

    @Deprecated
    @Override
    public boolean removeKeyFromSet(String key, String value) {
        Boolean member = redisTemplate.opsForSet().isMember(key, value);
        if(member != null && !member){
            return true;
        }
        Long remove = redisTemplate.opsForSet().remove(key, value);
        return (remove != null && remove > 0);
    }

    @Override
    public void deleteObject(String key) {
        Boolean flag = redisTemplate.hasKey(key);
        if(flag != null && !flag){
            throw new RedisObjectNotFoundException("redis has no such object with key: "+key);
        }
        redisTemplate.delete(key);
    }

    @Override
    public void deleteMember(String key, String value) {
        Boolean flag = redisTemplate.opsForSet().isMember(key, value);
        if(flag != null && !flag){
            throw new RedisObjectNotFoundException("redis has no such object in set with key: "+key+" value: "+value);
        }
        redisTemplate.opsForSet().remove(key,value);
    }
}
