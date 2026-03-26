package com.example.studentsystem.service;

import com.example.studentsystem.dto.GradeDto;
import com.example.studentsystem.model.Grade;
import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.GradeRepository;
import com.example.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Grade addGrade(GradeDto dto) {
        // Find the student or throw an error
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + dto.getStudentId()));

        // Create and save the new grade record
        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setSubject(dto.getSubject());
        grade.setScore(dto.getScore());

        return gradeRepository.save(grade);
    }

    public List<Grade> getStudentGrades(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
}