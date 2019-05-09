- ###[spring boot全系列博客推荐](https://blog.lqdev.cn/categories/)

- [本项目内容源自Spring4All](http://www.spring4all.com)

## SpringBoot
- [(官方)application.properties常用样板配置](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
- [(翻译)application.properties常用样板配置](https://blog.csdn.net/qq_28929589/article/details/79439795)

###SpringBoot推荐阅读
- [spring boot源码文档指南](http://blog.didispace.com/books/spring-boot-reference/)

###深入理解mybatis
- [深入理解mybatis原理](https://blog.csdn.net/u010349169/column/info/mybatis-principle)

#项目子代码顺序

### 0.其他内容 (此部分不分顺序，可单独查看)
- []
- [使用@Async实现异步调用 (线程池配置)](asynchronous/README.md)  
    相关文章：  
    [1.Spring中的线程池ThreadPoolTaskExecutor介绍](https://www.cnblogs.com/duanxz/p/5050227.html)  
    [2.springboot线程池的使用和扩展](https://www.cnblogs.com/pejsidney/p/9001875.html)  
    [3.Spring Boot线程池的使用心得](https://blog.csdn.net/m0_37701381/article/details/81072774)  
    [4.SpringBoot 自定义线程池](https://www.jianshu.com/p/832f2b162450)  
- [邮件发送](mail/README.md)

### 1. 多环境项目创建+数据访问部分
- [spring-boot](springboot/README.md)
- [multi-datasource](multi-datasource/README.md)
- [multi-datasource-jpa](multi-datasource-jpa/README.md)
- [spring-boot-redis](spring-boot-redis/README.md)
- [spring-boot-mongodb](spring-boot-mongodb/README.md)
- [mybatis](mybatis/README.md)

#### 1.1 深入理解spring-data-jpa

### 2. 事务管理
- [springboot事务管理](http://blog.didispace.com/springboottransactional/)

### 3. 日志管理  
推荐文章：
- [默认日志的配置](http://blog.didispace.com/springbootlog/)
- [使用log4j记录日志](http://blog.didispace.com/springbootlog4j/)
- [对log4j进行多环境不同日志级别的控制](http://blog.didispace.com/springbootlog4jmuilt/)
- [使用AOP统一处理Web请求日志](http://blog.didispace.com/springbootaoplog/)
- [使用log4j记录日志到MongoDB](http://blog.didispace.com/springbootlog4jmongodb/)
- [Spring Boot 1.5.x新特性：动态修改日志级别](http://blog.didispace.com/spring-boot-1-5-x-feature-1/)]


### 4. 缓存支持
- [cache](cache/README.md)

### 4. 安全管理
- [Spring Security全系列](http://www.spring4all.com/article/428)

### 5. 监控管理

#常用工具类
- 编码转换工具类 :`StringEscapeUtils`;包：`org.apache.commons.lang.*`,

#问题总结
- `@Qualifier`注解的使用
    - 详细方法看`multi-datasource`项目，`DataSourceConfig`配置类
        1. 在字段上使用，常和`@AutoWired`一起使用，否则无法注入
        2. 在方法参数上使用

- [`@Autowired`与`@Resource`的区别](https://blog.csdn.net/weixin_40423597/article/details/80643990)

- Spring-boot-redis依赖
    - `spring-boot-starter-redis`在`springboot 1.4.7版本`后,
    改为了`spring-boot-starter-data-redis`
    - redis配置 `spring.redis.pool.*`改成了`spring.redis.jedis.pool.*`