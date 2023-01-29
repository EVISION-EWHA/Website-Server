package com.example.evision.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId"})})

public class Users {
    @Id
    private String userId;

    @Column(nullable = false, name = "userPw")
    private String userPw;

    @Column(nullable = false, name = "email")
    private String email;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime signupDate;

    //대기 0, 승인 1, 거절 2, 추방 3
    @Column(nullable = false)
    private int authStatus = 0;

    @Builder
    public Users(String userId, String userPw, String email, LocalDateTime signupDate, int authStatus){
        this.userId = userId;
        this.userPw = userPw;
        this.email = email;
        this.signupDate = signupDate;
        this.authStatus = authStatus;
    }

}
