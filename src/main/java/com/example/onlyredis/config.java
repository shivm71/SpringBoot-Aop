package com.example.onlyredis;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;


@Configuration
public class config{

    @Autowired
    private JedisConnectionFactory ConnFactory;

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public JacksonJsonRedisSerializer<User> jacksonJsonRedisJsonSerializer() {
        JacksonJsonRedisSerializer<User> jacksonJsonRedisJsonSerializer = new JacksonJsonRedisSerializer<>(User.class);
        return jacksonJsonRedisJsonSerializer;
    }


    @Bean
    public RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(ConnFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jacksonJsonRedisJsonSerializer());
        return redisTemplate;
    }


}
