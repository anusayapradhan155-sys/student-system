package com.example.studentsystem.repository;

import com.example.studentsystem.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Custom method to fetch the report card (all grades) for a specific student
    List<Grade> findByStudentId(Long studentId);
}