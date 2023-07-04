package com.example.shopproject.config;

import com.example.shopproject.model.Role;
import com.example.shopproject.model.User;
import com.example.shopproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void initialize() {
        // Создаем пользователя с ролью ADMIN
        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setEmail("admin@mail.ru");
        adminUser.setPassword(passwordEncoder.encode("123")); // Хэшируем пароль
        adminUser.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        // Добавляем пользователя в базу данных
        userRepository.save(adminUser);
    }
}