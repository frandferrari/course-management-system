package com.frandferrari.course_management_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frandferrari.course_management_system.entities.Instructor;
import com.frandferrari.course_management_system.repositories.InstructorRepository;

@RestController
@RequestMapping(value = "/instructors")
public class InstructorController {

	private InstructorRepository instructorRepository;

	public InstructorController(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}

	@GetMapping
	public List<Instructor> findAllInstructors() {
		List<Instructor> result = instructorRepository.findAll();
		return result;
	}

}
