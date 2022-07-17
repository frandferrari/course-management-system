package com.frandferrari.course_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frandferrari.course_management_system.entities.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	
	@Query("SELECT e FROM Instructor e JOIN FETCH e.roles WHERE e.name= (:name)")
    public Instructor findByName(@Param("name") String name);

}
