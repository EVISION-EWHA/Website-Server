package com.example.evision.service;

import com.example.evision.DTO.ApplicationWithoutPwDTO;
import com.example.evision.DTO.AuthDTO;
import com.example.evision.DTO.RequestedUserDTO;
import com.example.evision.DTO.UserWithoutPwDTO;
import com.example.evision.entity.Users;
import com.example.evision.repository.ApplicationsRepository;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {
    private final UsersRepository usersRepository;
    private final ApplicationsRepository applicationsRepository;

    public List<RequestedUserDTO> getRequestedUsers(){
        return usersRepository.findUsersByAuthStatus();
    }

    public List<UserWithoutPwDTO> getAllUsers(){
        return usersRepository.findUserWithoutPw();
    }

    public void putAuthStatus(AuthDTO authDTO){
        Users user = usersRepository.findByUserId(authDTO.getUserId());
        user.setAuthStatus(authDTO.getAuthStatus());
        usersRepository.save(user);
    }

    public List<String> selectAllStudentId(){
        return applicationsRepository.selectAllSQL();
    }

    public ApplicationWithoutPwDTO getApplication(String studentId){
        return applicationsRepository.findByStudentId(studentId);
    }
}
