package com.example.evision.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;

@Slf4j
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "contents", uniqueConstraints = {@UniqueConstraint(columnNames = {"contentId"})})
public class Contents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contentId;

    @Column(nullable = false, name = "writerId")
    private String writerId;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime writeDate;

    @LastModifiedDate
    @Column(nullable = false)
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updateDate;

    @Column(name = "content")
    private String content;


    @Builder
    public Contents(int contentId, String writerId, LocalDateTime writeDate, LocalDateTime updateDate, String content){
        this.contentId = contentId;
        this.writerId = writerId;
        this.writeDate = writeDate;
        this.updateDate = updateDate;
        this.content = content;
    }

}
