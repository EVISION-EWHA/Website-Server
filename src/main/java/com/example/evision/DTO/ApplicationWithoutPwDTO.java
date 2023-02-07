package com.example.evision.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ApplicationWithoutPwDTO {
    private String studentId;
    private String name;
    private String phone;
    private String department;
    private boolean privacy;
    private boolean management;
    private String contentA;
    private String contentB;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ApplicationWithoutPwDTO(String studentId, String name, String phone, String department, boolean privacy, boolean management, String contentA, String contentB, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.studentId = studentId;
        this.name = name;
        this.phone = phone;
        this.department = department;
        this.privacy = privacy;
        this.management = management;
        this.contentA = contentA;
        this.contentB = contentB;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
