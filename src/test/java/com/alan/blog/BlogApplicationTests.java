package com.alan.blog;

import com.alan.blog.dao.redis.RedisReceiver;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.Set;


@SpringBootTest
class BlogApplicationTests {
    private final static Logger LOGGER = LoggerFactory.getLogger(BlogApplication.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("name", "alan");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    void redisTest() {
        Set<String> stringSet = redisTemplate.opsForSet().members("token");
        LOGGER.info(String.valueOf(stringSet.size()));
    }

}
