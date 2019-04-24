package com.leemon.asynchronous.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author limenglong
 * @create 2019-04-19 17:13
 * @desc 自定义线程池
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "myExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数（线程池创建时初始化的线程数）
        executor.setCorePoolSize(10);
        //最大线程数 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(15);
        //缓冲队列，用来缓冲执行任务的队列
        executor.setQueueCapacity(200);
        //允许线程的空闲时间，当超过了核心线程之外的线程在空闲时间达到之后会被销毁
        executor.setKeepAliveSeconds(60);
        //线程池的前缀 自定义线程名
        executor.setThreadNamePrefix("线程--");
        //是否指定核心线程超时（默认false）
        executor.setAllowCoreThreadTimeOut(false);
        //线程池对拒绝任务的处理策略
        //1)ThreadPoolExecutor.AbortPolicy策略，是默认的策略,处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
        //(2)ThreadPoolExecutor.CallerRunsPolicy策略 ,调用者的线程会执行该任务,如果执行器已关闭,则丢弃.
        //(3)ThreadPoolExecutor.DiscardPolicy策略，不能执行的任务将被丢弃.
        //(4)ThreadPoolExecutor.DiscardOldestPolicy策略，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）.
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //等待所有任务完成后，再销毁其他的Bean组件，然后关闭线程池
//        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超时还没有销毁就强制销毁，以确保程序能关闭，否则将一直阻塞；
//        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}
