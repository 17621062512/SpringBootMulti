package com.leemon.asynchronous.aysnc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author limenglong
 * @create 2019-04-24 17:56
 * @desc
 **/
@Component
public class AsyncTaskFive {

    private static final Logger log = LoggerFactory.getLogger(AsyncTaskFive.class);

    @Async
    public Future doTask() {
        log.info("开始执行任务。。。");
        long startTime = System.currentTimeMillis();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("任务执行完毕，" + "耗时:" + (endTime - startTime) + " 毫秒");
        return new AsyncResult("finished");
    }

}
