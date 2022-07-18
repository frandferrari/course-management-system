package com.frandferrari.course_management_system.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.frandferrari.course_management_system.entities.Administrator;
import com.frandferrari.course_management_system.repositories.AdministratorRepository;

@Component
public class StartApplication implements CommandLineRunner {

	@Autowired
	private AdministratorRepository administratorRepository;

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

		Administrator students = administratorRepository.findByUsername("student");
		if (students == null) {
			students = new Administrator();
			students.setName("STUDENT");
			students.setUsername("student");
			students.setPassword("student");
			students.getRoles().add("STUDENT");
			administratorRepository.save(students);
		}

		Administrator instructor = administratorRepository.findByUsername("instructor");
		if (instructor == null) {
			instructor = new Administrator();
			instructor.setName("INSTRUCTOR");
			instructor.setUsername("instructor");
			instructor.setPassword("instructor");
			instructor.getRoles().add("INSTRUCTOR");
			administratorRepository.save(instructor);

		}
	}

}
