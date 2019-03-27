### SpringBoot配置Redis
1. Spring-boot-redis依赖
      - `spring-boot-starter-redis`在`springboot 1.4.7版本`后,
       改为了`spring-boot-starter-data-redis`
      
2. `application.yml`配置文件配置redis连接属性
    - redis配置 `spring.redis.pool.*`改成了`spring.redis.jedis.pool.*`

3. 使用默认的RedisTemplate
```java
    @Autowired
    private StringRedisTemplate redisTemplate;
```
4. 使用自定义的RedisTemplate
    1. `Spring Boot`并不支持直接使用`RedisTemplate<String, User>`,需要实现`RedisSerializer`
        自定义序列化和反序列化操作,(类`RedisSerializer`)
    2. 自定义配置redis,需要注入`RedisConnectionFactory`,然后配置RedisTemplate。(类`RedisConfig`)
    3. 测试`MainTests` 