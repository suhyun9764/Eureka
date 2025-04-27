//package programmers;
//
//import java.util.*;
//
//public class Problem_크레인인형뽑기게임2 {
//    public static void main(String[] args) {
//        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
//        Solution solution = new Solution();
//        int answer = solution.solution(board, moves);
//        System.out.println(answer);
//    }
//
//    static class Solution {
//        public int solution(int[][] board, int[] moves) {
//           int[] col_top_idx = new int[board[0].length];    // 일차원 배열에 각 컬럼별 최상위 인형의 index관리
//
//            // 컬럼 (옆) 이동하면서
//            for(int col=0;col<col_top_idx.length;col++){
//                int top_idx = 0;
//                while (top_idx<board.length-1&&board[top_idx][col]==0) top_idx++;
//                col_top_idx[col] = top_idx;
//            }
//
//            Stack<Integer> bucket = new Stack<>();
//            int answer = 0;
//
//            for (int move : moves) {
//                if(col_top_idx[move-1]>board.length-1) continue; // 해당 열에서 꺼낼 인형 x
//
//                // 꺼낼 인형이 있다.
//                int doll = board[col_top_idx[move-1]][move-1];
//            }
//        }
//    }
//}
