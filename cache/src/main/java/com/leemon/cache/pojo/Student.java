package com.leemon.cache.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author limenglong
 * @create 2019-05-09 10:59
 * @desc 实体类
 **/
@Entity
@Data
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

}
