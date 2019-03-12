### SpringBoot使用JPA配置多数据源    
1. 首先配置`application.properties`
2. 配置数据源`DataSourceConfig.class`
    - 注意：配置多数据源时，其中一个数据源必须要加上`@Primary`注解，
        否则SpringBoot加载配置时会找不到相应的Bean组件
3. 配置 `PrimaryConfig`和`SecondaryConfig` （用`@Primary`区分主数据源）
4. 配置 数据访问接口`PrimaryRepository`,`SecondaryRepository`