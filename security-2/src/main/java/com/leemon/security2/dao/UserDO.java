package com.leemon.security2.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * @author limenglong
 * @create 2019-04-26 17:28
 * @desc
 **/
@Entity
@Table(name = "userdo")
@Data
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String nickname;
}
