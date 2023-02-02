package com.example.evision.repository;

import com.example.evision.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentsRepository extends JpaRepository<Contents, Integer> {
    Contents findByContentId(int contentId);
    boolean existsByContentId(int contentId);

    List<Contents> findAll();
}
