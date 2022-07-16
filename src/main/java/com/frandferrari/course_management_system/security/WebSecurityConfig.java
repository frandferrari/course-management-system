package com.frandferrari.course_management_system.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin",
                			 "/admin/instructors",
                			 "/admin/students",
                			 "/admin/instructors/{id}",
                			 "/admin/students/{id}",
                			 "/admin/",
                			 "/admin/instructors/",
                			 "/admin/students/",
                			 "/admin/instructors/{id}",
                			 "/admin/students/{id}").hasAnyRole("ADMIN")
                .antMatchers("/instructors","/instructors/").hasAnyRole("INSTRUCTOR","ADMIN")
                .antMatchers("/students","/students/").hasAnyRole("STUDENT","INSTRUCTOR","ADMIN")
                .anyRequest().authenticated().and().formLogin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin123")
                .roles("ADMIN")
                .and()
                .withUser("student")
                .password("{noop}student123")
                .roles("STUDENT")
                .and()
                .withUser("instructor")
                .password("{noop}instructor123")
                .roles("INSTRUCTOR");
        
    }
}