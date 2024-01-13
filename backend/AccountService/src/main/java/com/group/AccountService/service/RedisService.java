package com.group.AccountService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void cacheUserToken(String token, String userEmail) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("user:JWT:"+token, userEmail, 1, TimeUnit.DAYS);
    }

    public String getUserEmailByToken(String token) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get(token);
    }
}
