package com.example.evision.service;

import com.example.evision.entity.Boards;
import com.example.evision.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class BoardSevice {

    private final BoardRepository boardRepository;

    public void Write() {
        Boards boards = new Boards();
        boards.setUserID("test_0");
        boards.setTitle("HI");
        boards.setContent("aaa");
        boardRepository.save(boards);
    }

    public void Delete() {
        Boards boards = new Boards();

    }
}
