package com.leemon.asynchronous.aysnc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author limenglong
 * @create 2019-04-19 11:17
 * @desc
 **/
@Component
public class AsyncTaskTwo {
    //使用Futrue<T>返回异步回调结果

    @Async
    public Future<String> doTask1() throws InterruptedException {
        System.out.println("开始执行任务一。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        return new AsyncResult<>("任务一执行完毕");
    }

    @Async
    public Future<String> doTask2() throws InterruptedException {
        System.out.println("开始执行任务二。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        return new AsyncResult<>("任务二执行完毕");
    }

    @Async
    public Future<String> doTask3() throws InterruptedException {
        System.out.println("开始执行任务三。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        return new AsyncResult<>("任务三执行完毕");

    }
}
