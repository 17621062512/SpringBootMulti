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