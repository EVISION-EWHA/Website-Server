package com.example.evision.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardEditDTO {
    private String userId;
    private Integer contentId;
    private String content;
}
