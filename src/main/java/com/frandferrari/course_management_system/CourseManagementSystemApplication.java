package com.frandferrari.course_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CourseManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementSystemApplication.class, args);

	}

}
