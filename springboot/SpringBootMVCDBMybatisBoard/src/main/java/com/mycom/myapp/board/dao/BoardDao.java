package com.mycom.myapp.board.dao;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    // 목록
    List<BoardDto> listBoard(BoardParamDto boardParamDto);
    int listBoardTotalCount();
    List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto);
    int listBoardSearchWordTotalCount(BoardParamDto boardParamDto);
    BoardDto detailBoard(BoardParamDto boardParamDto);
    int insertBoard(BoardDto boardDto);
    int updateBoard(BoardDto boardDto);
    int deleteBoard(int boardId);

    // 상세 - 조회수
    // 현재 사용자가 현재 게시글을 읽었는지 판단
    int countBoardUserRead(BoardParamDto boardParamDto);    // boardId, userSeq
    // 현재 사용자가 현재 게시글을 읽었다는 표시 추가
    int insertBoardUserRead(BoardParamDto boardParamDto);
    // 현재 게시글의 조회수 증가
    int updateBoardReadCount(int boardId);
    int deleteBoardUserRead(int boardId);
}
