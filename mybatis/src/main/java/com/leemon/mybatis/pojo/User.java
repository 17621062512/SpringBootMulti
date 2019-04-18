package com.leemon.mybatis.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author limenglong
 * @create 2019-04-18 13:55
 * @desc 用户实体类
 **/

@Data
public class User {

    private Long id;
    private String name;
    private int age;

}
