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
    private String department;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ApplicationWithoutPwDTO(String studentId, String name, String department, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
