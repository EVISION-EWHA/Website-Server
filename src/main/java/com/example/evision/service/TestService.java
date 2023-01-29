package com.example.evision.service;

import com.example.evision.entity.Contents;
import com.example.evision.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final ContentsRepository contentsRepository;

    public String getHello(){
        String message = "hello";
        return message;
    }
    public void saveHello(){
        Contents contents = new Contents();
        contents.setWriterId("testId");
        contents.setContent("hello");
        contentsRepository.save(contents);
    }
}
