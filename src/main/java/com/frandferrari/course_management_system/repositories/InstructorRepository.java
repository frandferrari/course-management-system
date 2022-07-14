package com.frandferrari.course_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frandferrari.course_management_system.entities.Instructor;

public interface InstructorRepository extends JpaRepository <Instructor, Long>{

}
