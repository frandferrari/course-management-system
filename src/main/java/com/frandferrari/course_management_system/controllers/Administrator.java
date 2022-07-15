package com.frandferrari.course_management_system.controllers;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frandferrari.course_management_system.entities.Instructor;
import com.frandferrari.course_management_system.entities.Students;
import com.frandferrari.course_management_system.repositories.InstructorRepository;
import com.frandferrari.course_management_system.repositories.StudentsRepository;

@RestController
@RequestMapping(value = "/admin")
public class Administrator {

	private PasswordEncoder encoder;
	private InstructorRepository instructorRepository;
	private StudentsRepository studentsRepository;

	public Administrator(InstructorRepository instructorRepository, StudentsRepository studentsRepository) {
		this.instructorRepository = instructorRepository;
		this.studentsRepository = studentsRepository;
		this.encoder = new BCryptPasswordEncoder();
	}

	@GetMapping(value = "/instructors")
	public List<Instructor> findAllInstructors() {
		List<Instructor> result = instructorRepository.findAll();
		return result;
	}

	@GetMapping(value = "/instructor/{id}")
	public Instructor findInstructorById(@PathVariable Long id) {
		Instructor result = instructorRepository.findById(id).get();
		return result;
	}

	@PostMapping(value = "/instructor")
	public Instructor insert(@RequestBody Instructor instructor) {
		String encoder = this.encoder.encode(instructor.getPassword());
		instructor.setPassword(encoder);
		Instructor result = instructorRepository.save(instructor);
		return result;
	}

	@GetMapping(value = "/students")
	public List<Students> findAllStudents() {
		List<Students> result = studentsRepository.findAll();
		return result;
	}

	@GetMapping(value = "/students/{id}")
	public Students findStudentsById(@PathVariable Long id) {
		Students result = studentsRepository.findById(id).get();
		return result;
	}

	@PostMapping(value = "/students")
	public Students insert(@RequestBody Students student) {
		String encoder = this.encoder.encode(student.getPassword());
		student.setPassword(encoder);
		Students result = studentsRepository.save(student);
		return result;
	}

}
