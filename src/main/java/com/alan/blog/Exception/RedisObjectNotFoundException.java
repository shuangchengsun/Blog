package com.alan.blog.Exception;

public class RedisObjectNotFoundException extends RuntimeException {
    public RedisObjectNotFoundException() {
        super();
    }

    public RedisObjectNotFoundException(String message) {
        super(message);
    }
}
