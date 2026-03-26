package com.example.studentsystem.dto;

import java.time.LocalDate;

public class AttendanceDto {
    private Long studentId;
    private LocalDate date;
    private String status; // "PRESENT" or "ABSENT"

    // Getters and Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}