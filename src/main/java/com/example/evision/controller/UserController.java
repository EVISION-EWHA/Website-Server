package com.example.evision.controller;

import com.example.evision.DTO.LoginDTO;
import com.example.evision.DTO.UserDTO;
import com.example.evision.entity.Users;
import com.example.evision.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public int signup(@RequestBody UserDTO userDTO){
        return userService.userSignup(userDTO);
    }

    // 로그인 성공 : 대기 0, 승인 1, 거절 2, 추방 3
    // 로그인 실패 : 비밀번호 오류 -1, 아이디가 존재하지 않음 -2
    @PostMapping("/login")
    public int login(@RequestBody LoginDTO loginDTO){
        return userService.userLogin(loginDTO);
    }


}
