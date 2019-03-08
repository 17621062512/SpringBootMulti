package com.leemon.multidatasource.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTest {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void test() {

        primaryJdbcTemplate.queryForMap("select * from user where name='s'");
        secondaryJdbcTemplate.update("insert into user(name,age) values (?,?)", "流量", 22);
        secondaryJdbcTemplate.update("update user set name=?,age=?", "流量", 33);
        primaryJdbcTemplate.update("delete from user where id=?", 1);

    }
}
