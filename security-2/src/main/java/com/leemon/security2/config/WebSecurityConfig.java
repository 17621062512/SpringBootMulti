package com.leemon.security2.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author limenglong
 * @create 2019-04-26 16:14
 * @desc
 **/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication().withUser("user").
//                password(encoder.encode("123")).roles("USER");
        auth.userDetailsService("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 匹配 "/" 路径，不需要权限即可访问
         * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
         * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
         * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
         * 默认启用 CSRF
         */
        http.authorizeRequests().
                antMatchers("/").permitAll().
                antMatchers("/user/**").hasAuthority("USER").
                and().formLogin().loginPage("/login").defaultSuccessUrl("/user").
                and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }
}
