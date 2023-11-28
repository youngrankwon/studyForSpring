package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.study.spring.multiRouting"})
public class StudyForSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyForSpringApplication.class, args);
	}

}
