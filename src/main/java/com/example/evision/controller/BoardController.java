package com.example.evision.controller;

import com.example.evision.DTO.BoardAskDTO;
import com.example.evision.entity.Contents;
import com.example.evision.service.BoardService;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 49abf0108941e726c116c3360c573412c4131414

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{contentId}")
    public BoardAskDTO findByContentId(@PathVariable int contentId){
        return boardService.findByContentId(contentId);
    }

    @GetMapping()
    public List<Contents> getAllContents(){
        return boardService.getAllContents();
    }

    @PutMapping("/{userId}")
    public void putPost(@PathVariable String userId, @RequestBody BoardAskDTO boardAskDTO){
        boardService.putPost(userId, boardAskDTO);
    }
}
