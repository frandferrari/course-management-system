package com.frandferrari.course_management_system.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.frandferrari.course_management_system.entities.Administrator;
import com.frandferrari.course_management_system.repositories.AdministratorRepository;
import com.frandferrari.course_management_system.repositories.InstructorRepository;
import com.frandferrari.course_management_system.repositories.StudentsRepository;

@Component
public class StartApplication implements CommandLineRunner {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private StudentsRepository studentsRepository;
	@Autowired
	private AdministratorRepository administratorRepository;

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		Administrator administrator = administratorRepository.findByName("administrator");
		if (administrator == null) {
			administrator = new Administrator();
			administrator.setName("ADMIN");
			administrator.setName("admin");
			administrator.setPassword("admin");
			administrator.getRoles().add("ADMIN");
			administratorRepository.save(administrator);

		}

		administrator = administratorRepository.findByName("student");
		if (administrator == null) {
			administrator = new Administrator();
			administrator.setName("STUDENT");
			administrator.setName("student");
			administrator.setPassword("student");
			administrator.getRoles().add("STUDENT");
			administratorRepository.save(administrator);
		}

		administrator = administratorRepository.findByName("instructor");
		if (administrator == null) {
			administrator = new Administrator();
			administrator.setName("INSTRUCTOR");
			administrator.setName("instructor");
			administrator.setPassword("instructor");
			administrator.getRoles().add("INSTRUCTOR");
			administratorRepository.save(administrator);

		}
	}

}
