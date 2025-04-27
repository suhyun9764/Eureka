package com.mycom.myapp.board.dto;

import java.util.List;

public class BoardResultDto {
    private String result;  // 작업 성공, 실패
    private List<BoardDto> list;    // 목록
    private BoardDto dto;   // 상세
    private int count;  // 게시글 데이터 전체 건수

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<BoardDto> getList() {
        return list;
    }

    public void setList(List<BoardDto> list) {
        this.list = list;
    }

    public BoardDto getDto() {
        return dto;
    }

    public void setDto(BoardDto dto) {
        this.dto = dto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BoardResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dot=" + dto +
                ", count=" + count +
                '}';
    }
}
