package com.example.studentsystem.controller;

import com.example.studentsystem.dto.PasswordChangeDto;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.Authentication;
import java.util.HashMap;
import java.util.Map;
import com.example.studentsystem.dto.StudentRegistrationDto;
import com.example.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/me")
    public ResponseEntity<Map<String, String>> getCurrentUser(Authentication authentication) {
        Map<String, String> response = new HashMap<>();
        if (authentication == null) {
            response.put("error", "Not authenticated");
            return ResponseEntity.status(401).body(response);
        }

        // Extract username and their role (e.g., "ROLE_ADMIN" or "ROLE_STUDENT")
        response.put("username", authentication.getName());
        response.put("role", authentication.getAuthorities().iterator().next().getAuthority());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeDto dto, Authentication authentication) {
        // Double-check the user is actually logged in
        if (authentication == null) {
            return ResponseEntity.status(401).body("Not authenticated!");
        }

        try {
            // authentication.getName() gets the currently logged-in username
            studentService.changePassword(authentication.getName(), dto);
            return ResponseEntity.ok("Password updated successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody StudentRegistrationDto dto) {
        try {
            studentService.registerNewStudent(dto);
            return ResponseEntity.ok("Student registered successfully! You can now log in.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}