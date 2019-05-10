##SpringBoot使用缓存

###相关文章
- [史上最全面的Spring Boot Cache使用与整合](https://www.cnblogs.com/yueshutong/p/9381540.html)
- [Spring Boot中的缓存支持,注解配置与EhCache使用](http://blog.didispace.com/springbootcache1/)

###注意：
1. `Spring Boot Cache`缓存默认使用的是`CurrentMapCache`，  
是在jvm虚拟机中缓存的，使用`Spring Cache`，速度快，  
但会造成大量的内存消耗，不支持数据持久化，一旦项目死掉了，  
那么缓存数据也就没有了；
2. 使用`ehcache`缓存，支持jvm虚拟机缓存和磁盘存储(持久化存储)，  
磁盘存储需要开启配置(默认关闭)；建议单机使用，不建议分布式使用。  
通常用于二级缓存。
3. 使用`redis`缓存，只需要一个依赖,不需要`spring-boot-starter-cache`
    ```maven
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-redis</artifactId>
    </dependency>
    ```
    `application.properties`配置文件配置`redis`属性。  
    当你导入这一个依赖时，SpringBoot的CacheManager就会使用RedisCache。

###ehcache使用
推荐文章  
-[我们究竟什么时候使用Ehcache](https://blog.csdn.net/qq_32440951/article/details/78364856)

### 集中式缓存的对比及使用
推荐文章  
-[Redis和Memcache对比及优缺点](https://www.cnblogs.com/JavaBlackHole/p/7726195.html)

