package com.leemon.security2.config;

import com.leemon.security2.dao.UserDO;
import com.leemon.security2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author limenglong
 * @create 2019-04-26 17:25
 * @desc
 **/
@Service
public class DbUserDetailsService implements UserDetailsService {

    final UserService userService;

    @Autowired
    public DbUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userService.getByName(username);
        if (null == userDO) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        return new User(userDO.getUsername(), userDO.getPassword(), grantedAuthorities);
    }
}
