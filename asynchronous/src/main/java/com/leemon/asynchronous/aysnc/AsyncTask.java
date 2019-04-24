package com.leemon.asynchronous.aysnc;

import org.springframework.stereotype.Component;

/**
 * @author limenglong
 * @create 2019-04-19 10:56
 * @desc
 **/

@Component
public class AsyncTask {

    public void doTask1() throws InterruptedException {
        System.out.println("开始执行任务一。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务一执行完毕，"+"耗时:"+(endTime -startTime)+" 毫秒");
    }

    public void doTask2() throws InterruptedException {
        System.out.println("开始执行任务二。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务二执行完毕，"+"耗时:"+(endTime -startTime)+" 毫秒");

    }

    public void doTask3() throws InterruptedException {
        System.out.println("开始执行任务三。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("任务三执行完毕，"+"耗时:"+(endTime -startTime)+" 毫秒");

    }

}
