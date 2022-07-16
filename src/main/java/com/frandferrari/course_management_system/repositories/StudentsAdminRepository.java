package com.frandferrari.course_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frandferrari.course_management_system.entities.StudentsAdmin;

public interface StudentsAdminRepository extends JpaRepository<StudentsAdmin, Long> {
	
	

}
