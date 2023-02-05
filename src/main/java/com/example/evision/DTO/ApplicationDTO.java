package com.example.evision.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
public class ApplicationDTO {
    private String studentId;
    private String studentPw;
    private String name;
    private String phone;
    private String department;
    private boolean privacy;
    private boolean management;
    private String contentA;
    private String contentB;

}
