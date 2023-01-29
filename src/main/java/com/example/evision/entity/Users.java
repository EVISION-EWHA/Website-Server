package com.example.evision.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@NoArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"userid"})})

public class Users {
    @Id
    private String userid;

    @Column(nullable = false, name = "userpw")
    private String userpw;

    @Column(nullable = false, name = "email")
    private String email;

    @Builder
    public Users(String userid, String userpw, String email){
        this.userid = userid;
        this.userpw = userpw;
        this.email = email;
    }

}
