package com.example.evision.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthDTO {
    private String userId;
    private int authStatus;
}
