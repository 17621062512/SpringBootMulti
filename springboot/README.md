#SpringBoot

#### 1. spring-boot多环境配置
- 主配置文件 application.properties配置
`spring.profiles.active=@active@`。
选择环境时，使用通配符 `@@`，`active`为所选环境，对应`pom.xml`文件中的
```html
<properties>
    <active>prod</active>
</properties>
```

- maven配置文件 pom.xml 加入一下内容，详细内容查看`pom.xml`
 ```html
 <profiles>
     <profile>
         <id>prod</id>
         <properties>
             <active>prod</active>
         </properties>
     </profile>
  </profiles>
  
  <build>
    <filters>
        <filter>src/main/resources/${active}.properties</filter>
    </filters>
  </build>
 ```
#### 2. spring-boot 测试类测试Controller
- 详细内容查看`UserControllerTest`相关代码
- 使用`org.springframework.test.web.servlet.*`包下的相关类`MockMvc`等测试Controller
    1. 初始化`UserController`，方法：`MockMvcBuilders.standaloneSetup(UserController.class).build();`
      可以使用`@Before`注解，在调用其他方法之前先初始化该方法。
    2. ` MockMvcRequestBuilders.get("{param}");`构建请求。`{param}`为`Controller`的接口地址
    3. `mockMvc.perform(requestBuilder).andReturn()`执行请求并返回结果

#### 3. Swagger2自动生成Api文档
- Swagger常用注解说明：https://www.jianshu.com/p/12f4394462d5
- Swagger详细文档：`github`地址：https://github.com/SpringForAll/spring-boot-starter-swagger
- 项目中使用Swagger2
    1. 引入依赖
    ```html
     <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger2</artifactId>
          <version>2.7.0</version>
     </dependency>
     <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger-ui</artifactId>
          <version>2.7.0</version>
     </dependency>
    ```
    2. 项目启动类同级目录下创建`Swagger2`类，配置Swagger参数
    3. 在`Controller`接口方法上添加相关注解`@ApiOperation`,`@ApiImplicitParam`等
    
#### 4. spring-boot-JPA
- 使用Mysql数据库 
    - 引入依赖 
    ```html
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-data-jpa</artifactId>
      </dependency>
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>8.0.13</version>
      </dependency>
    ```
    1. `aplication.properties`配置mysql连接属性
    ```properties
       spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
       #设置时区,否则可能报错
       spring.datasource.url=jdbc:mysql://192.168.100.105:3306/test?serverTimezone=GMT%2b8
       spring.datasource.username=root
       spring.datasource.password=123321
     ```
    2. 给用户实体类`User`添加相关注解
    3. 用户实体类有`@Id`注解的成员属性需加上策略`@GeneratedValue(strategy = GenerationType.IDENTITY)`,
        具体策略需根据选用数据库做相应改动（本项目使用Mysql,所以为`IDENTITY`）
    4. 添加接口`UserRepository` 实现 `JpaRepository<T,ID>`
        jpaRepository提供了部分封装好的基本查询方法，实现自定义查询语句可以加注解`@Query("")`。
        查询语句默认使用HQL语法，也可以用`@Query(value = "", nativeQuery = true)`使用原生SQL查询语法。
        实现删改操作需添加`@Modify,@Transactional`注解，其中不加`@Transactional`可能会报事务管理异常或
        无法正常删改数据。
   