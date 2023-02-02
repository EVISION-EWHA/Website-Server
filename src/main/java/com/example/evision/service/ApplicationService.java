package com.example.evision.service;

import com.example.evision.DTO.ApplicationDTO;
import com.example.evision.entity.Applications;
import com.example.evision.repository.ApplicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationsRepository applicationsRepository;

    public int createApplication(ApplicationDTO applicationDTO){
        Applications application = new Applications();
        String studentId = applicationDTO.getStudentId();

        //이미 작성된 지원서가 있는 경우 -> 지원서 조회 페이지로 리다이렉트?
        if(applicationsRepository.existsByStudentId(studentId)){
            return -1;
        }
        application.setStudentId(studentId);
        application.setStudentPw(applicationDTO.getStudentPw());
        application.setName(applicationDTO.getName());
        application.setDepartment(applicationDTO.getDepartment());
        application.setContent(applicationDTO.getContent());

        applicationsRepository.save(application);
        return 0;
    }

    public Applications findApplication(String studentId){
        Applications application = applicationsRepository.findByStudentId(studentId);
        return application;
    }
}