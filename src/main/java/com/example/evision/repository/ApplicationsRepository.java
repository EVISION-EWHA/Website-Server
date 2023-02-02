package com.example.evision.repository;

import com.example.evision.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationsRepository extends JpaRepository<Applications, String> {
    Applications findByStudentId(String studentId);
    boolean existsByStudentId(String studentId);
}
