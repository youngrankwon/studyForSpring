package com.study.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestingWebApp.class)
public class StudyForSpringApplicationTests {

	@Test
	void contextLoads() {
	}

}