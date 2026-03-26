package com.example.studentsystem.repository;

import com.example.studentsystem.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Custom method to fetch attendance history for a specific student
    List<Attendance> findByStudentId(Long studentId);
}