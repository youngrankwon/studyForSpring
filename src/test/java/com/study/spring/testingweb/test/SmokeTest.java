package com.study.spring.testingweb.test;

import com.study.spring.TestingWebApp;
import com.study.spring.testingweb.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = TestingWebApp.class)
public class SmokeTest {
    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}
