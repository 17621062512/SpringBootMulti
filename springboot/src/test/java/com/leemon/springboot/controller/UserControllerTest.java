package com.leemon.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(UserController.class).build();
    }

    @Test
    public void test() throws Exception {
        //查询数据
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/");
        //        ResultActions actions = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String response = result.getResponse().getContentAsString();

        //插入数据
        requestBuilder = MockMvcRequestBuilders.post("/users/").param("id", "1").param("name", "里").param("age", "12");
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //查询刚刚插入的数据
        requestBuilder = MockMvcRequestBuilders.get("/users/");
//        ResultActions actions = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //根据id查询
        requestBuilder = MockMvcRequestBuilders.get("/users/1");
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //修改用户
        requestBuilder = MockMvcRequestBuilders.put("/users/1").param("id", "1").param("name", "刘").param("age", "24");
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //查询刚刚修改的用户
        requestBuilder = MockMvcRequestBuilders.get("/users/1");
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //删除数据
        requestBuilder = MockMvcRequestBuilders.delete("/users/1");
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

        //查询数据
        requestBuilder = MockMvcRequestBuilders.get("/users/");
//        ResultActions actions = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("[]")));
        result = mockMvc.perform(requestBuilder).andReturn();
        response = result.getResponse().getContentAsString();
        System.out.println(response);

    }
}
