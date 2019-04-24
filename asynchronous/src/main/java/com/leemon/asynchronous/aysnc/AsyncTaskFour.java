package com.leemon.asynchronous.aysnc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.function.Supplier;

/**
 * @author limenglong
 * @create 2019-04-23 16:31
 * @desc
 **/
@Component
public class AsyncTaskFour {

    private static final Logger log = LoggerFactory.getLogger(AsyncTask.class);

    final Executor executor;

    @Autowired
    public AsyncTaskFour(@Qualifier("myExecutor") Executor executor) {
        this.executor = executor;
    }

    public CompletableFuture doTask1() {
        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {

            log.info("开始执行任务一。。。");
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            log.info("任务一执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
            return "任务一完成";
        }, executor);

        return future;
    }


    public CompletableFuture<String> doTask2() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("开始执行任务二。。。");
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            log.info("任务二执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
            return "任务二完成";
        }, executor);

        return future;
    }

    public CompletableFuture<String> doTask3() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            log.info("开始执行任务三。。。");
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            log.info("任务三执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
            return "任务三完成";
        }, executor);
        return future;
    }

}
