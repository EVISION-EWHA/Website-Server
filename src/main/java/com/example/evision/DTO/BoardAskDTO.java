package com.example.evision.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardAskDTO {
    private String writerId;
    private LocalDateTime writeDate;
    private LocalDateTime updateDate;
    private String content;

}
