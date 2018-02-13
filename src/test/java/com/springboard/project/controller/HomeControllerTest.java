package com.springboard.project.controller;

import com.springboard.project.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
                                        /*Mock Request Builder*/
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
                                        /*Mock Result Builder*/

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class HomeControllerTest {

    /* Testing HomeController */

    @Autowired private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setup(){        /*Setup MockMvc*/
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/home")).andExpect(status().isOk());
    }


}
