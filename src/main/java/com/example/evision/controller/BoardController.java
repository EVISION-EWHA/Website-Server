package com.example.evision.controller;


import com.example.evision.DTO.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.evision.DTO.BoardAskDTO;
import com.example.evision.entity.Contents;
import com.example.evision.service.BoardService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/users")
    public String boardWrite(@RequestBody BoardDTO boardDTO) {
        return boardService.Write(boardDTO);
    }

    @DeleteMapping("/users/{boardID}")
    public String boardDelete(@PathVariable int boardID){
        boardService.Delete(boardID);
        return "redirect:/board";
    }


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
