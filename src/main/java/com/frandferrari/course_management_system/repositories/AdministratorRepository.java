package com.frandferrari.course_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frandferrari.course_management_system.entities.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	
	@Query("SELECT e FROM Administrator e JOIN FETCH e.roles WHERE e.name= (:name)")
    public Administrator findByName(@Param("name") String name);

}
