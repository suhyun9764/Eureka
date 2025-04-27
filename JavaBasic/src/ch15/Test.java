package ch15;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Board> list = new ArrayList<>();

        list.add(new Board("제목1","내용1","작성자1"));
        list.add(new Board("제목2","내용2","작성자2"));
        list.add(new Board("제목3","내용3","작성자3"));
        list.add(new Board("제목4","내용4","작성자4"));
        Board board = new Board("제목5","내용5","작성자5");

        list.add(board);
        System.out.println(list);   // Board의 toString( ) 재정의, 순서 유지
        System.out.println(list.size());    // 크기
        System.out.println(list.get(2));    // index 기반 객체 찾기

        // 중복
    }
}
