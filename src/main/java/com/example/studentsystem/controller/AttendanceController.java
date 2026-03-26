package com.example.studentsystem.controller;

import com.example.studentsystem.dto.AttendanceDto;
import com.example.studentsystem.model.Attendance;
import com.example.studentsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Endpoint for Admin to mark attendance
    @PostMapping("/mark")
    public ResponseEntity<String> markAttendance(@RequestBody AttendanceDto dto) {
        try {
            attendanceService.markAttendance(dto);
            return ResponseEntity.ok("Attendance marked successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint for Student/Admin to view history
    @GetMapping("/student/{id}")
    public ResponseEntity<List<Attendance>> getAttendance(@PathVariable Long id) {
        return ResponseEntity.ok(attendanceService.getStudentAttendance(id));
    }
}