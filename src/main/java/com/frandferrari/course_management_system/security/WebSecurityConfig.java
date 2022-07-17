package com.frandferrari.course_management_system.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired
	private SecurityDatabaseService securityService;
	
	 @Autowired
	    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin",
                			 "/admin/instructors",
                			 "/admin/students",
                			 "/admin/instructors/{id}",
                			 "/admin/students/{id}",
                			 "/admin/",
                			 "/admin/instructors",
                			 "/admin/students",
                			 "/admin/instructors/{id}",
                			 "/admin/students/{id}",
                			 "/h2-console").hasAnyRole("ADMIN")
                .antMatchers("/instructors","/instructors/").hasAnyRole("INSTRUCTOR","ADMIN")
                .antMatchers("/students","/students/").hasAnyRole("STUDENT","INSTRUCTOR","ADMIN")
                .anyRequest().authenticated().and().httpBasic();
    }
    
}