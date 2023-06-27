package com.example.shopproject.service.Impl;

import com.example.shopproject.dto.request.UserRq;

import com.example.shopproject.model.Role;
import com.example.shopproject.model.User;
import com.example.shopproject.repository.UserRepository;
import com.example.shopproject.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String register(UserRq userRq) {
        if (!userRq.getPassword().equals(userRq.getConfirmpassword())) {
            return "404";
        }
        if(userRepository.findByEmail(userRq.getEmail())!=null){
            return "404";
        }
        User user = new User();
        user.setPassword(passwordEncoder.encode(userRq.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        user.setUserName(userRq.getUsername());
        user.setEmail(userRq.getEmail());

        userRepository.saveAndFlush(user);
        return "redirect:/login";
    }
}
