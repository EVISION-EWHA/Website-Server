package com.example.evision.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestedUserDTO {
    private String userId;
    private String email;
    private LocalDateTime signupDate;

    public RequestedUserDTO(String userId, String email, LocalDateTime signupDate){
        this.userId = userId;
        this.email = email;
        this.signupDate = signupDate;
    }
}
