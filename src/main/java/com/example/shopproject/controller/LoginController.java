package com.example.shopproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/")
    public String products(){
        return "products";
    }
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

}
