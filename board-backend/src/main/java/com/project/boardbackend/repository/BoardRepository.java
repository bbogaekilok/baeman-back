package com.project.boardbackend.repository;

import com.project.boardbackend.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    // 게시글 등록
    public BoardDto save(BoardDto boardDto) {
        sql.insert("Board.save", boardDto);
        return boardDto;
    }

    // 게시글 조회 (모두)
    public List<BoardDto> findAll() {
        return sql.selectList("Board.findAll");
    }

    // 게시글 조회 (Id)
    public BoardDto findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    // 해당 Id 게시글 수정
    public void update(BoardDto boardDto) {
        sql.update("Board.update", boardDto);
    }

    public void deleteById(Long id) {
        sql.delete("Board.delete", id);
    }
}
