package com.example.studentsystem.service;

import com.example.studentsystem.dto.StudentRegistrationDto;
import com.example.studentsystem.model.Role;
import com.example.studentsystem.model.User;
import com.example.studentsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.studentsystem.model.Student;
import com.example.studentsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ADD THIS NEW METHOD
    public Student registerNewStudent(StudentRegistrationDto dto) {
        // 1. Check if the username is already taken
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken!");
        }

        // 2. Create the User (Login Credentials)
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword())); // ENCRYPT PASSWORD!
        user.setRole(Role.STUDENT); // Force the role to STUDENT

        // 3. Create the Student Profile
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());

        // 4. Link the User to the Student
        student.setUser(user);

        // Saving the student will automatically save the User because of CascadeType.ALL
        return studentRepository.save(student);
    }

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    // Add this below your existing methods
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setDepartment(studentDetails.getDepartment());

        return studentRepository.save(student);
    }
    public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        // Spring Data JPA pages are 0-indexed, so we subtract 1 from the pageNo
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return studentRepository.findAll(pageable);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Add this new method
    public void changePassword(String username, com.example.studentsystem.dto.PasswordChangeDto dto) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        // Check if the old password provided matches what is in the database
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) {
            throw new RuntimeException("Incorrect current password!");
        }

        // Encrypt and save the new password
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        userRepository.save(user);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);


    }
}