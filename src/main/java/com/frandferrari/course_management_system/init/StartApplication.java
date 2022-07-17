package com.frandferrari.course_management_system.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.frandferrari.course_management_system.entities.Administrator;
import com.frandferrari.course_management_system.entities.Instructor;
import com.frandferrari.course_management_system.entities.Students;
import com.frandferrari.course_management_system.repositories.AdministratorRepository;
import com.frandferrari.course_management_system.repositories.InstructorRepository;
import com.frandferrari.course_management_system.repositories.StudentsRepository;

@Component
public class StartApplication implements CommandLineRunner {

	@Autowired
	private AdministratorRepository administratorRepository;
	@Autowired
	private StudentsRepository studentsRepository;
	@Autowired
	private InstructorRepository instructorRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Administrator administrator = administratorRepository.findByUsername("administrator");
		if (administrator == null) {
			administrator = new Administrator();
			administrator.setName("ADMIN");
			administrator.setUsername("admin");
			administrator.setPassword("admin");
			administrator.getRoles().add("ADMIN");
			administratorRepository.save(administrator);

		}

		Students students = studentsRepository.findByUsername("student");
		if (students == null) {
			students = new Students();
			students.setName("STUDENT");
			students.setUsername("student");
			students.setPassword("student");
			students.getRoles().add("STUDENT");
			studentsRepository.save(students);
		}

		Instructor instructor = instructorRepository.findByUsername("instructor");
		if (instructor == null) {
			instructor = new Instructor();
			instructor.setName("INSTRUCTOR");
			instructor.setUsername("instructor");
			instructor.setPassword("instructor");
			instructor.getRoles().add("INSTRUCTOR");
			instructorRepository.save(instructor);

		}
	}

}
