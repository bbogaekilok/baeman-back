package com.project.boardbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;                        // 게시글 ID(pk)
    private String boardWriter;             // 작성자
    private String boardTitle;              // 제목
    private String boardContents;           // 내용
    private String createdAt;               // 생성일자

}
