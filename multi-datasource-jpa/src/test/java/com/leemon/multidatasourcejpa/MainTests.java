package com.leemon.multidatasourcejpa;

import com.leemon.multidatasourcejpa.repository.primary.PrimaryRepository;
import com.leemon.multidatasourcejpa.repository.secondary.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class MainTests {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondaryRepository secondaryRepository;

    @Test
    public void contextLoads() {

        primaryRepository.findUserByName("刘依依");
    }

}
