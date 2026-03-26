package com.example.studentsystem.repository;

import com.example.studentsystem.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
    // Basic CRUD operations are handled automatically
}