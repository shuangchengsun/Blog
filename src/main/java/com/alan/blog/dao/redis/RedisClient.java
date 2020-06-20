package com.alan.blog.dao.redis;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Set;

/*redis */
public interface RedisClient {

    public Object getObject(String key, Class instanceType) throws JsonProcessingException;
    public boolean setObject(String key, Object value);
    public void deleteObject(String key);

    /*操作redis集合*/
    public boolean setMembers(String key, String... strings);
    public Set getMembers(String key);
    public void deleteMember(String key, String value);

    public boolean removeKey(String Key);
    public boolean removeKeyFromSet(String key, String value);

}
