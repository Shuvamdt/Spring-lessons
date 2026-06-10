package com.springboot.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails ana = User.builder()
                .username("ana")
                .password("{noop}dearmas")
                .roles("EMPLOYEE")
                .build();

        UserDetails aneet = User.builder()
                .username("aneet")
                .password("{noop}padda")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails sneha = User.builder()
                .username("sneha")
                .password("{noop}pal")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(ana, aneet, sneha);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
        )
                .formLogin(form->
                        form
                                .loginPage("/showLoginForm")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );
        return httpSecurity.build();
    }
}
