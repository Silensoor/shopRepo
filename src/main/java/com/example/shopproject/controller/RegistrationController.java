package com.example.shopproject.controller;

import com.example.shopproject.dto.request.UserRq;
import com.example.shopproject.service.RegistrationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration";
    }
    @PostMapping("/register")
    public String registration(UserRq userRq)  {
        return registrationService.register(userRq);
    }

}
