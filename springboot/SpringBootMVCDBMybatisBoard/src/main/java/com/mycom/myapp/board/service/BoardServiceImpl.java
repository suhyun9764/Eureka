package com.mycom.myapp.board.service;

import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private final BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        try{
            List<BoardDto> list = boardDao.listBoard(boardParamDto);
            int count = boardDao.listBoardTotalCount();
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();

        try{
            List<BoardDto> list = boardDao.listBoardSearchWord(boardParamDto);
            int count = boardDao.listBoardSearchWordTotalCount(boardParamDto);
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult("success");
        }catch (Exception e){
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }
        return boardResultDto;
    }

    // 게시글 상세 정보 + 조회수 처리
    @Override
    @Transactional
    public BoardResultDto detailBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            // 조회수 처리
            // 게시글에 대한 현재 사용자의 조회 여부 확인
            int userReadCnt = boardDao.countBoardUserRead(boardParamDto);

            System.out.println("boardId : " + boardParamDto.getBoardId());
            System.out.println("userSeq : " + boardParamDto.getUserSeq());
            System.out.println("userReadCnt : " + userReadCnt);
            if(userReadCnt==0){ // 현재 게시글을 처음 읽는 상황
                boardDao.insertBoardUserRead(boardParamDto);    // 현재 게시글을 현재 사용작 읽었다 표시
                boardDao.updateBoardReadCount(boardParamDto.getBoardId());
            }
            // 게시글 상세 정보
            BoardDto boardDto = boardDao.detailBoard(boardParamDto);
            // sameUser
            if (boardDto.getUserSeq() == boardParamDto.getUserSeq())
                boardDto.setSameUser(true);
            else
                boardDto.setSameUser(false);
            boardResultDto.setDto(boardDto);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto insertBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try{
            int ret = boardDao.insertBoard(boardDto);
            if(ret==1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");
        }catch (Exception e){
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }
        return boardResultDto;
    }

    @Override
    public BoardResultDto updateBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try{
            int ret = boardDao.updateBoard(boardDto);
            if(ret==1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");
        }catch (Exception e){
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }
        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto deleteBoard(int boardId) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try{
            int ret1 = boardDao.deleteBoardUserRead(boardId);
            int ret2 = boardDao.deleteBoard(boardId);
            String s = null;
            s.length();
            if(ret1==1 && ret2==1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");
        }catch (Exception e){
            e.printStackTrace();
            boardResultDto.setResult("fail");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return boardResultDto;
    }
}
