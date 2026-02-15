package com.luv2code.springboot.cruddemo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT user_id, passwd, active FROM members WHERE user_id=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
        return userDetailsManager;
    }
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.GET, "/api/employees")
                .hasRole("EMPLOYEE"));
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.GET, "/api/employees/**")
                .hasRole("EMPLOYEE"));
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.POST, "/api/employees")
                .hasRole("MANAGER"));
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.PUT, "/api/employees")
                .hasRole("MANAGER"));
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**")
                .hasRole("ADMIN"));
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers(HttpMethod.PATCH, "/api/employees/**")
                .hasRole("MANAGER"));
        //mention level of authentication(Here Basic)
        http.httpBasic(Customizer.withDefaults());
        //remove csrf
        http.csrf(csrf->csrf.disable());

        return http.build();
    }
}
