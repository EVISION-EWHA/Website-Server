package com.example.evision.DTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
public class UserWithoutPwDTO {
    private String userId;
    private String email;
    private LocalDateTime signupDate;
    private int authStatus;

    public UserWithoutPwDTO(String userId, String email, LocalDateTime signupDate, int authStatus){
        this.userId = userId;
        this.email = email;
        this.signupDate = signupDate;
        this.authStatus = authStatus;
    }
}
