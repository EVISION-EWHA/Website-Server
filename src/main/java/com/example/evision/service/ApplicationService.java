package com.example.evision.service;

import com.example.evision.DTO.ApplicationDTO;
import com.example.evision.DTO.ApplicationWithoutPwDTO;
import com.example.evision.DTO.LoginDTO;
import com.example.evision.entity.Applications;
import com.example.evision.repository.ApplicationsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ApplicationsRepository applicationsRepository;

    public int createApplication(ApplicationDTO applicationDTO) {
        Applications application = new Applications();
        String studentId = applicationDTO.getStudentId();

        //이미 작성된 지원서가 있는 경우 -> 지원서 조회 페이지로 리다이렉트?
        if (applicationsRepository.existsByStudentId(studentId)) {
            return -1;
        }
        application.setStudentId(studentId);
        application.setStudentPw(passwordEncoder.encode(applicationDTO.getStudentPw()));
        application.setName(applicationDTO.getName());
        application.setPhone(applicationDTO.getPhone());
        application.setDepartment(applicationDTO.getDepartment());
        application.setPrivacy(applicationDTO.isPrivacy());
        application.setManagement(applicationDTO.isManagement());
        application.setContentA(applicationDTO.getContentA());
        application.setContentB(applicationDTO.getContentB());

        applicationsRepository.save(application);
        return 0;
    }

    public ApplicationWithoutPwDTO findApplication(String studentId) {
        return applicationsRepository.findByStudentId(studentId);
    }

    public boolean isValid(LoginDTO loginDTO) {
        String studentId = loginDTO.getUserId();
        if (applicationsRepository.existsByStudentId(studentId)) {
            Applications applications = applicationsRepository.findApplicationsByStudentId(studentId);
            if (passwordEncoder.matches(loginDTO.getUserPw(), applications.getStudentPw())) {
                return true;
            }
        }
        return false;
    }

    public Applications modifyApplication(ApplicationDTO applicationDTO){
        Applications application = applicationsRepository.findApplicationsByStudentId(applicationDTO.getStudentId());
        //json에서 해당하는 내용이 비어있지 않으면 내용 수정
        if(!applicationDTO.getStudentPw().isEmpty())
            application.setStudentPw(applicationDTO.getStudentPw());
        if(!applicationDTO.getName().isEmpty())
            application.setName(applicationDTO.getName());
        if(!applicationDTO.getPhone().isEmpty())
            application.setPhone(applicationDTO.getPhone());
        if(!applicationDTO.getDepartment().isEmpty())
            application.setDepartment(applicationDTO.getDepartment());
        if(!applicationDTO.getContentA().isEmpty())
            application.setContentA(applicationDTO.getContentA());
        if(!applicationDTO.getContentB().isEmpty())
            application.setContentB(applicationDTO.getContentB());
        //얘는 비어있을 수 없으니까(둘중 하나 무조건 선택) 그냥 선택할때마다 변경
        application.setManagement(applicationDTO.isManagement());

        applicationsRepository.save(application);
        return application;
    }
}
