package com.leemon.springboot;

import com.leemon.springboot.config.PropertiesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Test
    public void contextLoads() {
        propertiesConfig.getActive();
        propertiesConfig.getEnv();

    }

}
