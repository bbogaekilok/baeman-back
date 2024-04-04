package com.project.boardbackend.controller;

import com.project.boardbackend.dto.BoardDto;
import com.project.boardbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 등록
    @PostMapping("/save")
    public ResponseEntity<BoardDto> save(@RequestBody BoardDto boardDTO){
        BoardDto saveBoard = boardService.createBoard(boardDTO);
        return new ResponseEntity<>(saveBoard, HttpStatus.CREATED);
    }

    // 게시글 조회 (모두)
    @GetMapping
    public ResponseEntity<List<BoardDto>> getAllBoard(){
        List<BoardDto> boardList = boardService.getAllBoard();
        return ResponseEntity.ok(boardList);
    }

    // 게시글 조회 (id)
    @GetMapping("{id}")
    public ResponseEntity<BoardDto> getBoardById(@PathVariable("id") Long boardId){
        BoardDto boardDto = boardService.getBoardById(boardId);
        return ResponseEntity.ok(boardDto);
    }

    // 게시글 수정
    @PutMapping("{id}/{boardTitle}/{boardContents}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable("id") Long boardId,
                                                @PathVariable("boardTitle") String boardTitle,
                                                @PathVariable("boardContents") String boardContents){

        BoardDto updatedBoard = new BoardDto();
        updatedBoard.setBoardTitle(boardTitle);
        updatedBoard.setBoardContents(boardContents);

        BoardDto boardDto = boardService.updateBoard(boardId, updatedBoard);
        return ResponseEntity.ok(boardDto);
    }

    // 게시글 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long boardId){
        boardService.deleteById(boardId);
        return ResponseEntity.ok("delete success");
    }

}
