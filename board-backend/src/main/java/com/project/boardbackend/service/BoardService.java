package com.project.boardbackend.service;

import com.project.boardbackend.dto.BoardDto;

import java.util.List;

public interface BoardService{

    // 게시글 등록
    BoardDto createBoard(BoardDto boardDTO);

    // 게시글 모두 조회
    List<BoardDto> getAllBoard();

    // 게시글 조회 (해당 Id의 게시글 조회)
    BoardDto getBoardById(Long Id);

    // 게시글 수정 (해당 Id 게시글 수정)
    BoardDto updateBoard(Long Id, BoardDto updateBoard);

    // 게시글 삭제
    void deleteById(Long Id);


}
