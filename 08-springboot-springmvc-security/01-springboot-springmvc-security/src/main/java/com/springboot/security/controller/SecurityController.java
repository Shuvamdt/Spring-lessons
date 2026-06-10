package com.springboot.security.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/showLoginForm")
    public String showForm(){
        return "login-form";
    }
}
