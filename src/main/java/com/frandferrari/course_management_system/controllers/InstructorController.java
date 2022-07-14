package com.frandferrari.course_management_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frandferrari.course_management_system.entities.Instructor;
import com.frandferrari.course_management_system.repositories.InstructorRepository;

@RestController
@RequestMapping(value = "/instructor")
public class InstructorController {

private PasswordEncoder encoder;
	
	@Autowired
	private InstructorRepository repository;
	
	public InstructorController(InstructorRepository repository) {
		super();
		this.repository = repository;
		this.encoder = new BCryptPasswordEncoder();
	}

	@GetMapping
	public List<Instructor> findAll() {
		List<Instructor> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Instructor findById(@PathVariable Long id) {
		Instructor result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public Instructor insert(@RequestBody Instructor instructor) {
		String encoder = this.encoder.encode(instructor.getPassword());
		instructor.setPassword(encoder);
		Instructor result = repository.save(instructor);
		return result;
	}

}
