package com.example.bits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyAuthority("Student", "Teacher", "Admin")
                .antMatchers("/course").hasAnyAuthority("Student", "Teacher", "Admin")
                .antMatchers("/showCourseRegisterForm").hasAnyAuthority( "Teacher","Admin")
                .antMatchers("/showCourseUpdateForm/{id}").hasAnyAuthority( "Teacher","Admin")
                .antMatchers("/saveCourse").hasAnyAuthority( "Teacher","Admin")
                .antMatchers("/deleteCourse/**").hasAnyAuthority( "Admin")
                .antMatchers("/student").hasAnyAuthority("Student", "Teacher", "Admin")
                .antMatchers("/showStudentRegisterForm").hasAnyAuthority("Teacher", "Admin")
                .antMatchers("/saveStudent").hasAnyAuthority("Teacher","Admin")
                .antMatchers("/showStudentUpdateForm/{id}").hasAnyAuthority("Teacher","Admin")
                .antMatchers("/deleteStudent").hasAnyAuthority("Admin")
                .antMatchers("/users/edit").hasAnyAuthority( "Teacher", "Admin")
                .antMatchers("/users/edit/**").hasAnyAuthority( "Teacher", "Admin")
                .antMatchers("/users/delete/**").hasAuthority("Admin")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/users")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
