package com.example.evision.controller;

import com.example.evision.DTO.BoardDTO;
import com.example.evision.service.BoardSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardSevice boardSevice;

    @PostMapping("/users")
    public void boardWrite() {
        boardSevice.Write();
    }

    @DeleteMapping("users")
    public void boardDelete() {
        boardSevice.Delete();
    }


}
