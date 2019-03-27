package com.leemon.springbootredis.pojo;

import lombok.*;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private String userName;
    private Integer age;

}
