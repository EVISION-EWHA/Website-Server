package com.example.evision.service;

import com.example.evision.DTO.LoginDTO;
import com.example.evision.DTO.SignupDTO;
import com.example.evision.DTO.UserInfoDTO;
import com.example.evision.entity.Users;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UsersRepository usersRepository;

    public int userSignup(SignupDTO signupDTO){
        if(usersRepository.existsByUserId(signupDTO.getUserId())){ return -1; }
        Users user = new Users();
        user.setUserId(signupDTO.getUserId());
        user.setUserPw(passwordEncoder.encode(signupDTO.getUserPw()));
        user.setEmail(signupDTO.getEmail());
        usersRepository.save(user);
        return 0;
    }

    public int userLogin(LoginDTO loginDTO){
        Users user = usersRepository.findByUserId(loginDTO.getUserId());

        // 아이디가 존재하지 않는경우 -2(로그인 실패-아이디 조회 불가) 반환
        if(!usersRepository.existsByUserId(loginDTO.getUserId())){ return -2; }
        // 비밀번호 일치하지 않는 경우 -1(로그인 실패) 반환
//        if(!Objects.equals(user.getUserPw(), passwordEncoder.encode(loginDTO.getUserPw()))){ return -1; }

        if(!passwordEncoder.matches(loginDTO.getUserPw(), user.getUserPw())){ return -1; }

        return user.getAuthStatus();
    }

    public Users putUserInfo(String userId, UserInfoDTO userInfoDTO){
        Users user = usersRepository.findByUserId(userId);
        String newPw = userInfoDTO.getUserPw();
        String newEmail = userInfoDTO.getEmail();
        if(!newPw.isEmpty()){
            user.setUserPw(newPw);
        }
        if(!newEmail.isEmpty()){
            user.setEmail(newEmail);
        }
        usersRepository.save(user);
        return user;
    }
}
