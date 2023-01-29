package com.example.evision.controller;

import com.example.evision.DTO.AuthDTO;
import com.example.evision.entity.Users;
import com.example.evision.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/requests")
    public List<Users> getRequestedUsers(){
        return adminService.getUsersByAuthStatus(0);
    }

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return adminService.getAllUsers();
    }

    @PutMapping("/requests")
    public void putAuthStatus(@RequestBody AuthDTO authDTO){
        adminService.putAuthStatus(authDTO);
    }
}
