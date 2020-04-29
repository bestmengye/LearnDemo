package com.learn.mengye.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfiguration {

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate  stringSerializerRedisTemplate() {
        /**
         * spring-data-redis提供如下几种选择：
         *
         * GenericToStringSerializer: 可以将任何对象泛化为字符串并序列化
         * Jackson2JsonRedisSerializer: 跟JacksonJsonRedisSerializer实际上是一样的
         * JacksonJsonRedisSerializer: 序列化object对象为json字符串
         * JdkSerializationRedisSerializer: 序列化java对象
         * StringRedisSerializer: 简单的字符串序列化
         */
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setValueSerializer(RedisSerializer.string());
        redisTemplate.setHashKeySerializer(RedisSerializer.string());
        redisTemplate.setHashValueSerializer(RedisSerializer.string());
        return redisTemplate;
    }

}