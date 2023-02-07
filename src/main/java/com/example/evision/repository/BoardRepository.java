package com.example.evision.repository;

import com.example.evision.entity.Boards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Boards, String> {
    Boards findByBoardID(int boardID);

    List<Boards> findAll();
}
