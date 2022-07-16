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

import com.frandferrari.course_management_system.entities.InstructorAdmin;
import com.frandferrari.course_management_system.entities.StudentsAdmin;
import com.frandferrari.course_management_system.repositories.InstructorAdminRepository;
import com.frandferrari.course_management_system.repositories.StudentsAdminRepository;

@RestController
@RequestMapping(value = "/admin")
public class Administrator {

	private PasswordEncoder encoder;
	private InstructorAdminRepository instructorRepository;
	private StudentsAdminRepository studentsRepository;

	public Administrator(InstructorAdminRepository instructorRepository, StudentsAdminRepository studentsRepository) {
		this.instructorRepository = instructorRepository;
		this.studentsRepository = studentsRepository;
		this.encoder = new BCryptPasswordEncoder();
	}

	@GetMapping(value = "/instructors")
	public List<InstructorAdmin> findAllInstructors() {
		List<InstructorAdmin> result = instructorRepository.findAll();
		return result;
	}

	@GetMapping(value = "/instructors/{id}")
	public InstructorAdmin findInstructorById(@PathVariable Long id) {
		InstructorAdmin result = instructorRepository.findById(id).get();
		return result;
	}

	@PostMapping(value = "/instructors")
	public InstructorAdmin insert(@RequestBody InstructorAdmin instructor) {
		String encoder = this.encoder.encode(instructor.getPassword());
		instructor.setPassword(encoder);
		InstructorAdmin result = instructorRepository.save(instructor);
		return result;
	}

	@GetMapping(value = "/students")
	public List<StudentsAdmin> findAllStudents() {
		List<StudentsAdmin> result = studentsRepository.findAll();
		return result;
	}

	@GetMapping(value = "/students/{id}")
	public StudentsAdmin findStudentsById(@PathVariable Long id) {
		StudentsAdmin result = studentsRepository.findById(id).get();
		return result;
	}

	@PostMapping(value = "/students")
	public StudentsAdmin insert(@RequestBody StudentsAdmin student) {
		String encoder = this.encoder.encode(student.getPassword());
		student.setPassword(encoder);
		StudentsAdmin result = studentsRepository.save(student);
		return result;
	}

}
