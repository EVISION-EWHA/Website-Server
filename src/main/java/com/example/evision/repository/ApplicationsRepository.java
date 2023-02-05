package com.example.evision.repository;

import com.example.evision.DTO.ApplicationWithoutPwDTO;
import com.example.evision.entity.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationsRepository extends JpaRepository<Applications, String> {
    boolean existsByStudentId(String studentId);
    Applications findApplicationsByStudentId(String studentId);
    //id값만 리스트로 전체 반환
    @Query(value = "select application.studentId from Applications application")
    List<String> selectAllSQL();

    //해당하는 학번의 지원서 내용 중 pw 값 제외한 나머지 내용 반환
    @Query(value = "select new com.example.evision.DTO.ApplicationWithoutPwDTO(a.studentId, a.name, a.phone, a.department, a.privacy, a.management, a.contentA, a.contentB, a.createdDate, a.modifiedDate) from Applications a where a.studentId = :studentId")
    ApplicationWithoutPwDTO findByStudentId(@Param(value = "studentId") String studentId);
}
