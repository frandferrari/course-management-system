package com.frandferrari.course_management_system.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.frandferrari.course_management_system.entities.Administrator;
import com.frandferrari.course_management_system.entities.Instructor;
import com.frandferrari.course_management_system.repositories.AdministratorRepository;
import com.frandferrari.course_management_system.repositories.InstructorRepository;

@Service
public class SecurityDatabaseService implements UserDetailsService {
	@Autowired
	private AdministratorRepository administratorRepository;
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Administrator administratorEntity = administratorRepository.findByUsername(username);
		if (administratorEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		administratorEntity.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		UserDetails user = new org.springframework.security.core.userdetails.User(administratorEntity.getName(),
				administratorEntity.getPassword(), authorities);
		return user;
	}

	public UserDetails loadInstructorByUsername(String username) {
		Instructor instructorEntity = instructorRepository.findByUsername(username);
		if (instructorEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		instructorEntity.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		UserDetails user = new org.springframework.security.core.userdetails.User(instructorEntity.getName(),
				instructorEntity.getPassword(), authorities);
		return user;
	}

}
