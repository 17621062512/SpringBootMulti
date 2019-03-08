package com.leemon.springboot.repository;

import com.leemon.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    User deleteByName(String name);

    User findByNameAndAge(String name, int age);


    //HQL语法
    @Query(value = "from User where name=:name")
    User findUserByName(@Param("name") String name);

    //使用原生SQL语法
    @Query(value = "select * from user where id=:id", nativeQuery = true)
    User findUserById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update User set age=:age where name=:name")
    int updateUser(@Param("age") int age, @Param("name") String name);
}
