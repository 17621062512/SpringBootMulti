package com.leemon.springboot.controller;

import com.leemon.springboot.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //线程安全的Map
    private Map<Long, User> map = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(map.values());
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        map.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "查询用户", notes = "根据Id查询用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户Id", dataType = "long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") long id) {
        return map.get(id);
    }

    @ApiOperation(value = "更新用户信息", notes = "根据url的Id来指定更新对象,并根据传过来的user信息来更新用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", dataType = "long", paramType = "path"),
            @ApiImplicitParam(name = "u", value = "用户详细实体user", dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUserById(@PathVariable("id") long id, @ModelAttribute User u) {
        User user = map.get(id);
        user.setName(u.getName());
        user.setAge(u.getAge());
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据id删除用户")
    @ApiImplicitParam(name = "id", value = "用户Id", dataType = "long",paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id") long id) {
        map.remove(id);
        return "success";
    }
}
