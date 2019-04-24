package com.leemon.asynchronous.aysnc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author limenglong
 * @create 2019-04-23 14:42
 * @desc
 **/


@Component
public class AsyncTaskThree {

    private static final Logger log = LoggerFactory.getLogger(AsyncTask.class);

    @Async("myExecutor")
    public Future<String> doTask1() throws InterruptedException {
        log.info("开始执行任务一。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        log.info("任务一执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
        return new AsyncResult("任务一完成");
    }

    @Async("myExecutor")
    public Future<String> doTask2() throws InterruptedException {
        log.info("开始执行任务二。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        log.info("任务二执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
        return new AsyncResult("任务二完成");
    }

    @Async("myExecutor")
    public Future<String> doTask3() throws InterruptedException {
        log.info("开始执行任务三。。。");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        log.info("任务三执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
        return new AsyncResult("任务三完成");
    }


}
