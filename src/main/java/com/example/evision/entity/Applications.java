package com.example.evision.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
public class Applications {
    @Id
    private String studentId;

    @Column(nullable = false, name = "studentPw")
    private String studentPw;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    //지원서 작성한 내용(추후 콘텐츠 수정)
    @Column(name = "content")
    private String content;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime modifiedDate;

    @Builder
    public Applications(String studentId, String studentPw, String name, String department, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.studentId = studentId;
        this.studentPw = studentPw;
        this.name = name;

        this.department = department;
        this.content = content;

        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
