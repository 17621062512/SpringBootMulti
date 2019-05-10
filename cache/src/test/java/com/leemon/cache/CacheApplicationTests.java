package com.leemon.cache;

import com.leemon.cache.pojo.Student;
import com.leemon.cache.service.IStudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private CacheManager cacheManager;

//    @Before
    public void before() {

        Student student = new Student();

        student.setId((long) 10001);
        student.setName("李书记");
        student.setAge(32);

        studentService.save(student);

    }

    @Test
    public void contextLoads() throws InterruptedException {


        Student stu1 = studentService.findByName("李书记");
        System.out.println("第一次查询:" + stu1.getAge());

//        int age = stu1.getAge();
//        stu1.setAge(age + 2);
//
//        studentService.update(stu1);
//        System.out.println("更新数据,年龄由 " + age + " 变为 " + (age + 2));

        Student stu2 = studentService.findByName("李书记");
        System.out.println("第二次查询:" + stu2.getAge());

        Student stu3 = studentService.findByName("李书记");
        System.out.println("第三次查询:" + stu3.getAge());

//        studentService.delete(stu3);

        System.out.println("结束");
    }

}
