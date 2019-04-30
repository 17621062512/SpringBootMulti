package com.leemon.security2.service.impl;

import com.leemon.security2.dao.UserDO;
import com.leemon.security2.repository.UserRepository;
import com.leemon.security2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author limenglong
 * @create 2019-04-29 09:54
 * @desc
 **/

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void insert(UserDO userDO) {
        String username = userDO.getUsername();
        if (exist(username)) {
            log.info("数据插入失败：用户名已经存在！");
        } else {
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));

            userRepository.save(userDO);
        }
    }

    @Override
    public UserDO getByName(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean exist(String username) {
        UserDO userDO = userRepository.findByUsername(username);
        return userDO != null;
    }
}
