package com.leemon.security2.repository;

import com.leemon.security2.dao.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author limenglong
 * @create 2019-04-26 17:54
 * @desc
 **/

@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUsername(String username);
}
