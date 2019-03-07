#SpringBoot
####spring-boot多环境配置
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
####spring-boot 测试类测试Controller
- 使用`org.springframework.test.web.servlet.*`相关类`MockMvc`等测试Controller
    1. 初始化`UserController`，方法：`MockMvcBuilders.standaloneSetup(UserController.class).build();`
      可以使用`@Before`注解，在调用其他方法之前先初始化该方法。
    2. 