package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
public class TestingWebApp {

	public static void main(String[] args) {
		SpringApplication.run(TestingWebApp.class, args);
	}

}
