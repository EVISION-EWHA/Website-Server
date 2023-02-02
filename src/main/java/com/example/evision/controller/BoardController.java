package com.example.evision.controller;

import com.example.evision.DTO.BoardAskDTO;
import com.example.evision.entity.Contents;
import com.example.evision.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/{contentId}")
    public BoardAskDTO findByContentId(@PathVariable int contentId){
        return boardService.findByContentId(contentId);
    }

    @GetMapping("/board")
    public List<Contents> getAllContents(){
        return boardService.getAllContents();
    }
}
