package com.alan.blog.dal.dao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class RedisReceiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(RedisReceiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public String receiveMessage(String message){
        LOGGER.info("redis received <" + message +">");
        counter.incrementAndGet();
        return message;
    }

    public int getCount(){
        return counter.get();
    }


}
