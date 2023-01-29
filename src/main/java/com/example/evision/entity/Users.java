package com.example.evision.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"userId"})})

public class Users {
    @Id
    private String userId;

    @Column(nullable = false, name = "userPw")
    private String userPw;

    @Column(nullable = false, name = "email")
    private String email;

    @Builder
    public Users(String userId, String userPw, String email){
        this.userId = userId;
        this.userPw = userPw;
        this.email = email;
    }

}
