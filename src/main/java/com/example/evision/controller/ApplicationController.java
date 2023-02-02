package com.example.evision.controller;

import com.example.evision.DTO.ApplicationDTO;
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

    @GetMapping("/{studentId}")
    public Applications findApplication(@PathVariable String studentId){
        return applicationService.findApplication(studentId);
    }
}
