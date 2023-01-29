package com.example.evision.controller;

import com.example.evision.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping
    public String getHello() {
        return testService.getHello();
    }
    @PostMapping("/database")
    public void saveHello(){
        testService.saveHello();
    }
}
