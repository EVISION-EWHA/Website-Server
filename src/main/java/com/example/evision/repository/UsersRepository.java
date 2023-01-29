package com.example.evision.repository;

import com.example.evision.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUserId(String userId);
    boolean existsByUserId(String userId);
}
