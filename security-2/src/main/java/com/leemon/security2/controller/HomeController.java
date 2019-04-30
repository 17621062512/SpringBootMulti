package com.leemon.security2.controller;

import com.leemon.security2.dao.UserDO;
import com.leemon.security2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author limenglong
 * @create 2019-04-29 10:05
 * @desc
 **/
@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/","/index","/home"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserDO userDO){
        userService.insert(userDO);
        return "redirect:register?sucess";
    }
}
