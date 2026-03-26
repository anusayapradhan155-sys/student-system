package com.example.studentsystem.service;

import com.example.studentsystem.dto.AttendanceDto;
import com.example.studentsystem.model.Attendance;
import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.AttendanceRepository;
import com.example.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Attendance markAttendance(AttendanceDto dto) {
        // Find the student or throw an error
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + dto.getStudentId()));

        // Create and save the new attendance record
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(dto.getDate());
        attendance.setStatus(dto.getStatus().toUpperCase());

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getStudentAttendance(Long studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }
}