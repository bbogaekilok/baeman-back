package com.project.boardbackend.service.impl;

import com.project.boardbackend.dto.BoardDto;
import com.project.boardbackend.repository.BoardRepository;
import com.project.boardbackend.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    public BoardDto createBoard(BoardDto boardDTO) {
        boardRepository.save(boardDTO);
        return boardDTO;
    }

    @Override
    public List<BoardDto> getAllBoard() {
        List<BoardDto> boardList = boardRepository.findAll();

        return boardList;
    }

    @Override
    public BoardDto getBoardById(Long Id) {
        BoardDto boardDto = boardRepository.findById(Id);
        return boardDto;
    }

    @Override
    public BoardDto updateBoard(Long Id, BoardDto updateBoard) {

        BoardDto boardDto = boardRepository.findById(Id);

        boardDto.setBoardTitle(updateBoard.getBoardTitle());
        boardDto.setBoardWriter(updateBoard.getBoardWriter());
        boardDto.setBoardContents(updateBoard.getBoardContents());

        boardRepository.update(boardDto);

        return boardDto;
    }

    @Override
    public void deleteById(Long Id) {
        boardRepository.deleteById(Id);
    }

}
