package com.leemon.springboot.controller;

import com.leemon.springboot.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //线程安全的Map
    private Map<Long, User> map = Collections.synchronizedMap(new HashMap<>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(map.values());
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        map.put(user.getId(), user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) {
        return map.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUserById(@PathVariable("id") long id, @ModelAttribute User u) {
        User user = map.get(id);
        user.setId(u.getId());
        user.setName(u.getName());
        user.setId(u.getAge());
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") long id) {
        map.remove(id);
        return "success";
    }
}
