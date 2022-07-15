package com.frandferrari.course_management_system.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class WellcomeController {

	@RestController
	public class WelcomeController {
	    @GetMapping
	    public String welcome(){
	        return "Welcome to My Spring Boot Web API";
	    }
	    @GetMapping("/students")
	    public String students() {
	        return "Authorized user";
	    }
	    @GetMapping("/instructors")
	    public String instructors() {
	        return "Authorized manager";
	    }
	}
}
