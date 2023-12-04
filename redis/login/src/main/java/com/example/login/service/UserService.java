package com.example.login.service;

import com.example.login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public UserService(final RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public UserDto getSessionAttribute(String sessionId, String attributeName) {
        String hashName = "spring:session:sessions:" + sessionId;
        final Set<String> keys = redisTemplate.keys("name");
        final UserDto user = (UserDto) redisTemplate.opsForHash().get(hashName, "sessionAttr:" + attributeName);
        return user;
    }
}
