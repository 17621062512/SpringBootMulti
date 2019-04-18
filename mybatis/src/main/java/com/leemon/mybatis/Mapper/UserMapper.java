package com.leemon.mybatis.Mapper;


import com.leemon.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author limenglong
 * @create 2019-04-18 13:58
 * @desc mybatis映射
 **/
@Mapper
public interface UserMapper {

    //插入操作
    //使用@Param传参
    @Insert(value = "insert into user(name,age) values(#{name},#{age})")
    boolean insertUser(@Param("name") String name, @Param("age") int age);

    //使用Map传参
    @Insert(value = "insert into user(name,age) values(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    boolean insertUserByMap(Map<String, Object> map);

    //使用对象传参
    @Insert(value = "insert into user(name,age) values(#{name},#{age})")
    boolean insertByUser(User u);


    //查询操作
    @Select(value = "select * from user where id=#{id}")
    User getUserById(@Param("id") Long id);

    //修改操作
    @Update(value = "update user set age=#{age} where name=#{name}")
    boolean updateById(User u);

    //删除操作
    @Delete(value = "delete from user where id=#{id}")
    boolean deleteById(@Param("id") Long id);

    //多表关联的情况可以使用@Results和@Result来绑定属性返回一个不同于实体类User的包装类（暂时还用User接收结果）
    //property对应User的成员变量，column对应SQL语句的字段
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select(value = "select name,age from user")
    List<User> findAll();
}
