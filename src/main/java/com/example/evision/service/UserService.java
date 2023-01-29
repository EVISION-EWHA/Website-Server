package com.example.evision.service;

import com.example.evision.DTO.LoginDTO;
import com.example.evision.DTO.UserDTO;
import com.example.evision.entity.Users;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public int userSignup(UserDTO userDTO){
        Users user = new Users();
        user.setUserId(userDTO.getUserId());
        user.setUserPw(userDTO.getUserPw());
        user.setEmail(userDTO.getEmail());
        usersRepository.save(user);
        return user.getAuthStatus();
    }

    public int userLogin(LoginDTO loginDTO){
        Users user = usersRepository.findByUserId(loginDTO.getUserId());

        // 아이디가 존재하지 않는경우 -2(로그인 실패-아이디 조회 불가) 반환
        if(!usersRepository.existsByUserId(loginDTO.getUserId())){
            return -2;
        }
        // 비밀번호 일치하지 않는 경우 -1(로그인 실패) 반환
        if(!Objects.equals(user.getUserPw(), loginDTO.getUserPw())){
            return -1;
        }

        return user.getAuthStatus();
    }
}
