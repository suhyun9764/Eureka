package com.mycom.myapp.board.service;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;

public interface BoardService {
    BoardResultDto listBoard(BoardParamDto boardParamDto);
    BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto);
    BoardResultDto detailBoard(BoardParamDto boardParamDto);
    BoardResultDto insertBoard(BoardDto boardDto);
    BoardResultDto updateBoard(BoardDto boardDto);
    BoardResultDto deleteBoard(int boardId);

    //컨트롤러가 바라보는 boardService는 별도의 조회수 관련 메서드를 따로 가지 않는다
    //detailBoard()에서 모두 처리
    
}
