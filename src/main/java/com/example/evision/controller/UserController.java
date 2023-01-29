package com.example.evision.controller;

import com.example.evision.DTO.LoginDTO;
import com.example.evision.DTO.SignupDTO;
import com.example.evision.DTO.UserInfoDTO;
import com.example.evision.entity.Users;
import com.example.evision.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public int signup(@RequestBody SignupDTO signupDTO){
        return userService.userSignup(signupDTO);
    }


    @PostMapping("/login")
    public int login(@RequestBody LoginDTO loginDTO){
        // 로그인 성공 : 대기 0, 승인 1, 거절 2, 추방 3
        // 로그인 실패 : 비밀번호 오류 -1, 아이디가 존재하지 않음 -2
        return userService.userLogin(loginDTO);
    }

    @PutMapping("/users/{userId}")
    public Users putUserInfo(@PathVariable String userId, @RequestBody UserInfoDTO userInfoDTO){
        return userService.putUserInfo(userId, userInfoDTO);
    }


}
