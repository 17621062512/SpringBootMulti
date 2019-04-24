##SpringBoot @Asyn异步调用
- [注意] @Asyn修饰的函数不要定义`static`类型，否则异步调用不会生效 
#### 异步任务测试
1. 类`AsyncTask`  
    初步测试：定义了三个方法，执行`doTask1(),doTask2(),doTask3()`,循环3次.  
    结果：按照代码顺序执行方法，耗时很长
2. 类`AsyncTaskTwo`  
    使用`@Asyn`注解将函数变为异步函数，[注意:使用`@Asyn`注解时，应在程序主函数配置注解`@EnableAsync`]  
    测试：定义了三个方法，执行`doTask1(),doTask2(),doTask3()`,循环3次.  
    结果：开启了异步执行方法，但是相关的任务输出有异常(不显示或乱序)  
    原因：主程序异步调用方法后，并不会理会三个方法是否执行完成，  
    由于没有其他任务执行，程序自动结束了，所以导致了任务输出不完整；
    
    优化：异步回调，使用`Future<T>`返回异步回调结果
3. 类`AsyncTaskThree` 自定义线程池
    1. 自定义配置线程池(`config.TheadPoolConfig类`)
    2. 使用`@Async`注解将函数变为异步函数，并指定线程池名，即可使用自定义线程池
    3. 测试：定义了三个方法，执行`doTask1(),doTask2(),doTask3()`,循环3次。
    4. 结果：使用自定义线程池了开启异步执行，但是相关任务输出不完整；
    5. 原因：当程序执行完之后控制台停止打印，但异步任务还在执行；
    6. 优化：  
        1.（方法一）设置参数`setWaitForTasksToCompleteOnShutdown`和`setAwaitTerminationSeconds`,  
        等待所有任务执行完之后在关闭线程池(如果线程最大等待时间内任务没完成，就会被强制销毁)；  
        2.（方法二）使用异步回调的方式获取任务执行结果
        
        
4. 针对`Future<T>`的优化(未完善)  
    1. 分析：使用`Future`取异步回调结果，会导致CPU高速轮询，耗资源，不推荐  
    2. 方案：JDK8定义了`CompletableFuture`可以代替`Future`，避免轮询获取结果
    3. ()

    推荐文章：  
    [Java8新特性整理之CompletableFuture(多线程取结果鬼记得几种方案)](https://blog.csdn.net/u011726984/article/details/79320004)  
    [CompletableFuture 使用详解](https://www.jianshu.com/p/6bac52527ca4)

5. 自定义线程池拓展  
    相关类：(未完成)  
    1. 目的：整合异步定时任务配置和线程池配置
    2. 使用自定义线程池重写`Spring`默认的线程池  
        2.1 与第三节的对比，上面的线程池使用的时候总是需要在`@Async`  
        注解后面加上自定义的线程池标识`@Async("myExecutor")`,  
        重写默认线程池之后只需要添加`@Async`注解就可以了  
    3. 并行执行定时任务配置  