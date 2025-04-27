package programmers;

import java.util.*;

public class Problem_크레인인형뽑기게임 {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Solution solution = new Solution();
        int answer = solution.solution(board, moves);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            // 뽑은 인형을 담을 바구니
            Deque<Integer> basket = new ArrayDeque<>();
            // board를 스택 구조로 변경
            List<Deque<Integer>> boardStack = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                Deque<Integer> section = new ArrayDeque<>();
                for (int j = board.length - 1; j >= 0; j--) {
                    if (board[j][i] != 0)
                        section.push(board[j][i]);
                }
                boardStack.add(section);
            }

            // 모든 작동 순회
            for (int position : moves) {
                Deque<Integer> currentSection = boardStack.get(position-1);
                // 비어있지 않은 경우에만
                if (!currentSection.isEmpty()) {
                    int doll = currentSection.pop();
                    // 바구니 최상단에 있는거랑 같다면 둘다 제거
                    if(!basket.isEmpty()&&basket.peek()==doll){
                        basket.pop();
                        answer+=2;
                    }else{
                        basket.push(doll);
                    }
                }
            }
            return answer;
        }
    }
}
