package com.mycom.myapp.board.controller;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;
import com.mycom.myapp.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    @ResponseBody
    public BoardResultDto listBoard(BoardParamDto boardParamDto){
        BoardResultDto boardResultDto = null;

        if(Strings.isEmpty(boardParamDto.getSearchWord())){
            boardResultDto=boardService.listBoard(boardParamDto);
        }else{
            boardResultDto = boardService.listBoardSearchWord(boardParamDto);
        }
//
//        String s = null;
//        s.length();

        return boardResultDto;
    }

    // Controller 에서 session에 담긴 현재 조회 사용자의 userSeq를 service에 전달
    @GetMapping("/detail/{boardId}")
    @ResponseBody
    public BoardResultDto listBoard(@PathVariable("boardId") int boardId, HttpSession session){
        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setBoardId(boardId);
        int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq();
        boardParamDto.setUserSeq(userSeq);
        return boardService.detailBoard(boardParamDto);
    }

    @PostMapping("/insert")
    @ResponseBody
    public BoardResultDto insertBoard(BoardDto boardDto, HttpSession session){
        int userSeq = ((UserDto) session.getAttribute("userDto")).getUserSeq();
        boardDto.setUserSeq(userSeq);
        return boardService.insertBoard(boardDto);
    }

    @PostMapping("/update")
    @ResponseBody
    public BoardResultDto updateBoard(BoardDto boardDto){
        return boardService.updateBoard(boardDto);
    }

    @GetMapping("/delete/{boardId}")
    @ResponseBody
    public BoardResultDto updateBoard(@PathVariable Integer boardId){
        return boardService.deleteBoard(boardId);
    }


}
