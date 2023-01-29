package com.example.evision.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@NoArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "contents", uniqueConstraints = {@UniqueConstraint(columnNames = {"contentid"})})
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String contentid;

    @Column(nullable = false, name = "writerid")
    private String writerid;

    @CreatedDate
    private LocalDateTime writedate;

    @Column(name = "content")
    private String content;


    @Builder
    public Contents(String contentid, String writerid, LocalDateTime writedate, String content){
        this.contentid = contentid;
        this.writerid = writerid;
        this.writedate = writedate;
        this.content = content;
    }

}
