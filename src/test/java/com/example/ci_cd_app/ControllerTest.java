package com.example.ci_cd_app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("CI/CD Demo Application is running!"));
    }

    @Test
    void testHello() throws Exception {
        mockMvc.perform(get("/hello/World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World! Welcome to CI/CD world!"));
    }

    @Test
    void testCalculatorAdd() throws Exception {
        mockMvc.perform(get("/calculator/add/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 8"));
    }
}
