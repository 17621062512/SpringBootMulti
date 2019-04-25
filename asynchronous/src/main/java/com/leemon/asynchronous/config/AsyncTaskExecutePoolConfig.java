package com.leemon.asynchronous.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.*;

/**
 * @author limenglong
 * @create 2019-04-24 15:37
 * @desc 自定义线程池配置拓展
 **/

@Configuration
public class AsyncTaskExecutePoolConfig implements AsyncConfigurer, SchedulingConfigurer {

    private static final Logger log = LoggerFactory.getLogger(AsyncTaskExecutePoolConfig.class);

    /**********************重写定时任务,实现异步执行定时任务**********************/
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //注册定时任务
        taskRegistrar.setTaskScheduler(taskScheduler());

    }

    private ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        //设置定时任务线程池大小
        taskScheduler.setPoolSize(10);
        //线程池的前缀 自定义线程名
        taskScheduler.setThreadNamePrefix("定时任务线程-");
        //等待所有任务完成后，再销毁其他的Bean组件，然后关闭线程池
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超时还没有销毁就强制销毁，以确保程序能关闭，否则将一直阻塞；
        taskScheduler.setAwaitTerminationSeconds(60);
        return taskScheduler;
    }

    /**********************重写线程池**********************/
    //线程池配置
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new VisibleThreadPoolTaskExecutor();
        //是否指定核心线程超时（默认false）
        executor.setAllowCoreThreadTimeOut(false);
        //允许线程的空闲时间，当超过了核心线程之外的线程在空闲时间达到之后会被销毁
        executor.setKeepAliveSeconds(60);
        //缓冲队列，用来缓冲执行任务的队列
        executor.setQueueCapacity(999);
        //核心线程数（线程池创建时初始化的线程数）
        executor.setMaxPoolSize(20);
        //最大线程数 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setCorePoolSize(10);
        //饱和策略
        //AbortPolicy策略，是默认的策略,处理程序遭到拒绝将抛出运行时 RejectedExecutionException。
        //CallerRunsPolicy策略 ,调用者的线程会执行该任务,如果执行器已关闭,则丢弃.
        //DiscardPolicy策略，不能执行的任务将被丢弃.
        //DiscardOldestPolicy策略，如果执行程序尚未关闭，则位于工作队列头部的任务将被删除，然后重试执行程序（如果再次失败，则重复此过程）.
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程池的前缀 自定义线程名
        executor.setThreadNamePrefix("线程--");
        //等待所有任务完成后，再销毁其他的Bean组件，然后关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置线程池中任务的等待时间，如果超时还没有销毁就强制销毁，以确保程序能关闭，否则将一直阻塞；
//        executor.setAwaitTerminationSeconds(60);
        return executor;
    }

    //异步任务中的异常处理策略
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) -> {
            log.error("Action:---------------" + ex.getMessage() + "---------------", ex);
            log.error("抛出异常的方法:" + method.getName());
        };
    }


    //自定义VisibleThreadPoolTaskExecutor继承ThreadPoolTaskExecutor
    private class VisibleThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

        {
            initialize();
        }

        //展示线程池信息
        private void showThreadPoolInfo(String prefix) {
            ThreadPoolExecutor executor = getThreadPoolExecutor();

            if (null == executor) {
                return;
            }

            log.info("{},任务总数：{},完成的任务数量：{},活跃的线程数量：{},缓冲队列中的任务数量：{}",
                    prefix,
                    executor.getTaskCount(),
                    executor.getCompletedTaskCount(),
                    executor.getActiveCount(),
                    executor.getQueue().size());
        }

        @Override
        public void execute(Runnable task) {
            showThreadPoolInfo("do execute(Runnable task)");
            super.execute(task);
        }

        @Override
        public void execute(Runnable task, long startTimeout) {
            showThreadPoolInfo("do execute(Runnable task, long startTimeout)");
            super.execute(task, startTimeout);
        }

        @Override
        public Future<?> submit(Runnable task) {
            showThreadPoolInfo("do submit(Runnable task)");
            return super.submit(task);
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            showThreadPoolInfo("do submit(Callable<T> task)");
            return super.submit(task);
        }

        @Override
        public ListenableFuture<?> submitListenable(Runnable task) {
            showThreadPoolInfo("do submitListenable(Runnable task)");
            return super.submitListenable(task);
        }

        @Override
        public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
            showThreadPoolInfo("do submitListenable(Callable<T> task)");
            return super.submitListenable(task);
        }

    }
}
