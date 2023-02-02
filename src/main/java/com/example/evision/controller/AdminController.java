package com.example.evision.controller;

import com.example.evision.DTO.ApplicationWithoutPwDTO;
import com.example.evision.DTO.AuthDTO;
import com.example.evision.DTO.RequestedUserDTO;
import com.example.evision.DTO.UserWithoutPwDTO;
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
    public List<RequestedUserDTO> getRequestedUsers() {return adminService.getRequestedUsers();}

    @GetMapping("/users")
    public List<UserWithoutPwDTO> getAllUsers(){
        return adminService.getAllUsers();
    }

    @PutMapping("/requests")
    public void putAuthStatus(@RequestBody AuthDTO authDTO){
        adminService.putAuthStatus(authDTO);
    }

    @GetMapping("/applications")
    public List<String> selectAllStudentId(){
        return adminService.selectAllStudentId();
    }

    @GetMapping("/applications/{studentId}")
    public ApplicationWithoutPwDTO getApplication(@PathVariable String studentId){
        return adminService.getApplication(studentId);
    }
}
