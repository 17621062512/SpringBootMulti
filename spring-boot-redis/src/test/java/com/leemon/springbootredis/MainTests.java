package com.leemon.springbootredis;

import com.leemon.springbootredis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUserName("老1");
        user.setAge(21);

        User user1 = new User();
        user1.setUserName("小3");
        user1.setAge(32);

        userRedisTemplate.opsForValue().set(user.getUserName(), user);
        userRedisTemplate.opsForValue().set(user1.getUserName(), user1);

        userRedisTemplate.opsForValue().get("小张");
    }

}
