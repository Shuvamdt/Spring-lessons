package com.luv2code.springboot.cruddemo.security;


import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails riju = User.builder()
                .username("riju")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails sneha = User.builder()
                .username("sneha")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails shuvam = User.builder()
                .username("shuvam")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(shuvam, sneha, riju);
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
