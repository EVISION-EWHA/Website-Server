package com.example.evision.repository;

import com.example.evision.DTO.RequestedUserDTO;
import com.example.evision.DTO.UserWithoutPwDTO;
import com.example.evision.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUserId(String userId);
    boolean existsByUserId(String userId);

    //authStatus == 0인 사람의 requested 정보(id, email, 가입일자)를 리스트로 반환
    @Query(value = "select new com.example.evision.DTO.RequestedUserDTO(user.userId, user.email, user.signupDate) from Users user where user.authStatus = 0")
    List<RequestedUserDTO> findUsersByAuthStatus();

    //가입된 모든 사용자의 정보(pw만 제외)를 리스트로 반환
    @Query(value = "select new com.example.evision.DTO.UserWithoutPwDTO(user.userId, user.email, user.signupDate, user.authStatus) from Users user")
    List<UserWithoutPwDTO> findUserWithoutPw();

    List<Users> findAll();
}
