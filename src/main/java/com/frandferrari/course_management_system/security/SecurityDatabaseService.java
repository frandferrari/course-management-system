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
import com.frandferrari.course_management_system.repositories.AdministratorRepository;

@Service
public class SecurityDatabaseService implements UserDetailsService {
	@Autowired
	private AdministratorRepository administratorRepository;

	@Override
	public UserDetails loadUserByUsername(String name) {
		Administrator administratorEntity = administratorRepository.findByName(name);
		if (administratorEntity == null) {
			throw new UsernameNotFoundException(name);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		administratorEntity.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		});
		UserDetails user = new org.springframework.security.core.userdetails.User(administratorEntity.getName(),
				administratorEntity.getPassword(), authorities);
		return user;
	}

}
