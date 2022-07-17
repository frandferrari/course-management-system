package com.frandferrari.course_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frandferrari.course_management_system.entities.Students;

public interface StudentsRepository extends JpaRepository<Students, Long> {

	@Query("SELECT e FROM Students e JOIN FETCH e.roles WHERE e.username= (:username)")
	public Students findByUsername(@Param("username") String username);

}
