package com.example.evision.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignupDTO {
    private String userId;
    private String userPw;
    private String email;
}
