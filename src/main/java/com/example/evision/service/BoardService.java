package com.example.evision.service;

import com.example.evision.DTO.BoardAskDTO;
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


    public String Write(String writerId, BoardDTO boardDTO) {
        Contents contents = new Contents();
        contents.setContentId(boardDTO.getContentId());
        contents.setWriterId(boardDTO.getWriterId());
        contents.setContent(boardDTO.getContent());
        contentsRepository.save(contents);
        return "Board saved successfully";

    }


    public void Delete(int contentId) {
        Contents contents = contentsRepository.findByContentId(contentId);
        contentsRepository.delete(contents);
    }

    public void putPost(String writerId, BoardEditDTO boardEditDTO){
        Contents content = contentsRepository.findByWriterId(writerId);
        content.setContent(boardEditDTO.getContent());
        contentsRepository.save(content);
    }
}
