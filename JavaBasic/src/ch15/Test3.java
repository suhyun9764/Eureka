package ch15;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        //Set
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("hello");
        set.add("java");
        set.add("world");
        set.add("world");

        for (String str : set) {
            System.out.println(str);
        }

        //Board
        Set<Board> boardSet = new HashSet<>();
        boardSet.add(new Board("제목1","내용1","작성자1"));
        boardSet.add(new Board("제목2","내용2","작성자2"));
        boardSet.add(new Board("제목3","내용3","작성자3"));
        boardSet.add(new Board("제목4","내용4","작성자4"));
        boardSet.add(new Board("제목1","내용1","작성자1"));

        for (Board board : boardSet) {
            System.out.println(board);
        }
    }
}
