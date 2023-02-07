package com.example.evision.controller;

import com.example.evision.DTO.ApplicationDTO;
import com.example.evision.DTO.ApplicationWithoutPwDTO;
import com.example.evision.DTO.LoginDTO;
import com.example.evision.entity.Applications;
import com.example.evision.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping
    public int createApplication(@RequestBody ApplicationDTO applicationDTO){
        return applicationService.createApplication(applicationDTO);
    }

    @GetMapping
    public ApplicationWithoutPwDTO findApplication(@RequestBody LoginDTO loginDTO){
        if(applicationService.isValid(loginDTO)){
            return applicationService.findApplication(loginDTO.getUserId());
        }
        else return null;
    }

    @PutMapping
    public Applications modifyApplication(@RequestBody ApplicationDTO applicationDTO){
        return applicationService.modifyApplication(applicationDTO);
    }
}
