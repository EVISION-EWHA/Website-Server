package com.example.evision.service;

import com.example.evision.DTO.BoardAskDTO;
import com.example.evision.DTO.BoardCheckDTO;
import com.example.evision.DTO.BoardDTO;
import com.example.evision.DTO.BoardEditDTO;
import com.example.evision.entity.Contents;
import com.example.evision.entity.Users;
import com.example.evision.repository.ContentsRepository;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final ContentsRepository contentsRepository;

    public BoardAskDTO findByContentId(int contentId){
        Contents contents = contentsRepository.findByContentId(contentId);

        BoardAskDTO boardAskDTO = new BoardAskDTO();
        boardAskDTO.setContent(contents.getContent());
        boardAskDTO.setWriterId(contents.getWriterId());
        boardAskDTO.setWriteDate(contents.getWriteDate());
        boardAskDTO.setUpdateDate(contents.getUpdateDate());
        return boardAskDTO;
    }

    public List<Contents> getAllContents(){
        return contentsRepository.findAll();
    }


    public Integer Write(BoardDTO boardDTO) {
        Contents contents = new Contents();
        contents.setWriterId(boardDTO.getWriterId());
        contents.setContent(boardDTO.getContent());
        Contents newContent = contentsRepository.save(contents);
        return newContent.getContentId();

    }


    public Integer Delete(BoardCheckDTO boardCheckDTO) {
        Contents contents = contentsRepository.findByContentId(boardCheckDTO.getContentId());
        if(contents.getWriterId().equals(boardCheckDTO.getUserId())){
            contentsRepository.delete(contents);
            return 1;
        }
        return 0;
    }

    public Contents putPost(BoardEditDTO boardEditDTO){
        Contents content = contentsRepository.findByContentId(boardEditDTO.getContentId());
        if(content.getWriterId().equals(boardEditDTO.getUserId())){
            content.setContent(boardEditDTO.getContent());
            return contentsRepository.save(content);
        }
        return null;
    }
}
