package com.example.studentsystem.controller;

import com.example.studentsystem.dto.GradeDto;
import com.example.studentsystem.model.Grade;
import com.example.studentsystem.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
@CrossOrigin
public class GradeController {

    @Autowired
    private GradeService gradeService;

    // Endpoint for Admin to add a grade
    @PostMapping("/add")
    public ResponseEntity<String> addGrade(@RequestBody GradeDto dto) {
        try {
            gradeService.addGrade(dto);
            return ResponseEntity.ok("Grade added successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint for Student/Admin to view the report card
    @GetMapping("/student/{id}")
    public ResponseEntity<List<Grade>> getGrades(@PathVariable Long id) {
        return ResponseEntity.ok(gradeService.getStudentGrades(id));
    }
}