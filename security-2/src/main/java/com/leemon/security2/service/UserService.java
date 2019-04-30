package com.leemon.security2.service;

import com.leemon.security2.dao.UserDO;

public interface UserService {

    /**
     * 添加新用户
     * <p>
     * username 唯一， 默认 USER 权限
     */
    void insert(UserDO userDO);

    /**
     * 查询用户信息
     *
     * @param username 账号
     * @re
     */
    UserDO getByName(String username);
}
