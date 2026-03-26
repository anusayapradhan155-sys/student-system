package com.example.studentsystem.controller;

import org.springframework.data.domain.Page;
import jakarta.validation.Valid;
import com.example.studentsystem.model.Student;
import com.example.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin // Allows our frontend to communicate with this API
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student added successfully!";
    }

    @GetMapping("/paginated")
    public Page<Student> getPaginatedStudents(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "id") String sortField,
            @RequestParam(defaultValue = "asc") String sortDir) {

        return studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
    }
    // Add this below your existing routes
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        studentService.updateStudent(id, studentDetails);
        return "Student updated successfully!";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}