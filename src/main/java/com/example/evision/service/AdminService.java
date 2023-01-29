package com.example.evision.service;

import com.example.evision.DTO.AuthDTO;
import com.example.evision.entity.Users;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {
    private final UsersRepository usersRepository;

    public List<Users> getUsersByAuthStatus(int authStatus){
        return usersRepository.findByAuthStatus(authStatus);
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void putAuthStatus(AuthDTO authDTO){
        Users user = usersRepository.findByUserId(authDTO.getUserId());
        user.setAuthStatus(authDTO.getAuthStatus());
        usersRepository.save(user);
    }
}
