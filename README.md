#知识点总结
- `@Qualifier`注解的使用
    - 详细方法看`multi-datasource`项目，`DataSourceConfig`配置类
    1. 在字段上使用，和`@AutoWired`一起使用，否则无法注入
    2. 在方法参数上使用
    