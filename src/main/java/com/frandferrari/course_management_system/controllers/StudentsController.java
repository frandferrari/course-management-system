package com.frandferrari.course_management_system.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frandferrari.course_management_system.entities.Students;
import com.frandferrari.course_management_system.repositories.StudentsRepository;

@RestController
@RequestMapping(value = "/students")
public class StudentsController {

	private StudentsRepository studentsRepository;

	public StudentsController(StudentsRepository studentsRepository) {
		this.studentsRepository = studentsRepository;
	}

	@GetMapping
	public List<Students> findAllInstructors() {
		List<Students> result = studentsRepository.findAll();
		return result;
	}

}
