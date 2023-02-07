package com.example.evision.service;

import com.example.evision.DTO.BoardAskDTO;
import com.example.evision.entity.Contents;
import com.example.evision.entity.Users;
import com.example.evision.repository.ContentsRepository;
import com.example.evision.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    private final ContentsRepository contentsRepository;

    public BoardAskDTO findByContentId(int contentId){
        Contents contents = contentsRepository.findByContentId(contentId);

        //contentId가 존재하지 않는 경우
//        if(!contentsRepository.existsByContentId(contentId)){
//            return -1;
//        }
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

    public void putPost(String writerId, BoardAskDTO boardAskDTO){
        Contents content = contentsRepository.findByWriterId(writerId);
        content.setContent(boardAskDTO.getContent());
        contentsRepository.save(content);
    }
}
