package com.example.studentsystem.config;

import com.example.studentsystem.model.Role;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the admin user already exists
            if (userRepository.findByUsername("admin").isEmpty()) {

                // Create a new user, ENCRYPT the password, and set role to ADMIN
                User admin = new User(
                        "admin",
                        passwordEncoder.encode("admin123"),
                        Role.ADMIN
                );

                userRepository.save(admin);
                System.out.println("Default Admin User securely created in the database!");
            }
        };
    }
}