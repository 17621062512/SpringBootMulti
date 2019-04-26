package com.leemon.security2.repository;

import com.leemon.security2.dao.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author limenglong
 * @create 2019-04-26 17:54
 * @desc
 **/
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUsername(String username);
}
