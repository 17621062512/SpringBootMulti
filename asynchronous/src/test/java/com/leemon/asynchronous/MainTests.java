package com.leemon.asynchronous;

import com.leemon.asynchronous.aysnc.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    AsyncTask task;

    @Autowired
    AsyncTaskTwo taskTwo;

    @Autowired
    AsyncTaskThree taskThree;

    @Autowired
    AsyncTaskFour taskFour;

    @Autowired
    AsyncTaskFive taskFive;

    @Test
    public void contextLoads() throws Exception {


        long begin = System.currentTimeMillis();

        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
//            task.doTask1();
//            task.doTask2();
//            task.doTask3();

            Future<String> future1 = taskTwo.doTask1();
            Future<String> future2 = taskTwo.doTask2();
            Future<String> future3 = taskTwo.doTask3();

            futureList.add(future1);
            futureList.add(future2);
            futureList.add(future3);
        }

        futureList.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - begin) + "毫秒");

    }

    @Test
    public void testTaskThree() throws InterruptedException {
//        long begin = System.currentTimeMillis();
//
//        for (int i = 0; i < 3; i++) {
//            taskThree.doTask1();
//            taskThree.doTask2();
//            taskThree.doTask3();
//        }
//
//        long end = System.currentTimeMillis();
//
//        System.out.println("总耗时：" + (end - begin) + "毫秒");

        //优化
        long begin = System.currentTimeMillis();

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            futures.add(taskThree.doTask1());
            futures.add(taskThree.doTask2());
            futures.add(taskThree.doTask3());
        }

        futures.forEach(stringFuture -> {
            try {
                System.out.println(stringFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - begin) + "毫秒");
    }


    @Test
    public void testTaskFour() throws InterruptedException {

        try {
            CompletableFuture.allOf(taskFour.doTask1(),taskFour.doTask2(),taskFour.doTask3()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testTaskFive() throws InterruptedException {
        long begin = System.currentTimeMillis();
        List<Future> futures = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
           futures.add( taskFive.doTask());
        }

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end - begin) + "毫秒");


    }
}
