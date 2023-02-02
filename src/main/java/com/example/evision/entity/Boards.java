package com.example.evision.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "boards", uniqueConstraints = {@UniqueConstraint(columnNames = {"boardID"})})
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int boardID;


    private String userID;

    private String title;

    private String content;

    public Boards(int boardID, String userID, String title, String content) {
        this.boardID = boardID;
        this.userID = userID;
        this.title = title;
        this.content = content;
    }

}
