package com.leemon.springbootmongodb;

import com.leemon.springbootmongodb.pojo.User;
import com.leemon.springbootmongodb.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {

        User user = new User(3L, "老刘", 32);

        userRepository.save(user);

        userRepository.findByUsername("老刘");

    }

}
