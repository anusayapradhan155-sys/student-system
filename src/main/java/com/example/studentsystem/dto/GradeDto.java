package com.example.studentsystem.dto;

public class GradeDto {
    private Long studentId;
    private String subject;
    private Double score;

    // Getters and Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
}