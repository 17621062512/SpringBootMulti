package com.leemon.mybatis;

import com.leemon.mybatis.Mapper.UserMapper;
import com.leemon.mybatis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {

//        userMapper.insertUser("lily", 12);

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "james");
//        map.put("age", 20);
//        userMapper.insertUserByMap(map);

//        User u = new User();
//        u.setName("老王");
//        u.setAge(14);
//        userMapper.insertByUser(u);

//        User user = userMapper.getUserById((long) 5);
//        user.setAge(76);
//        userMapper.updateById(user);

//        userMapper.deleteById((long)3);

        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

}
