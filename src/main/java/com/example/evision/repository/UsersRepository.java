package com.example.evision.repository;

import com.example.evision.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUserId(String userId);
    boolean existsByUserId(String userId);
    List<Users> findByAuthStatus(int authStatus);
    List<Users> findAll();
}
