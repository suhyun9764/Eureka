package programmers;

import java.util.Arrays;

public class Problem_n제곱배열자르기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(3, 2, 5);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(int n, long left, long right) {
            int[] arr = new int[(int)(right-left+1)];
            for(long i=left;i<=right;i++){
                int y = (int)(i/n+1);
                int x = (int)(i%n+1);
                arr[(int)(i-left)] = Math.max(y,x);
            }
            return arr;
        }
    }
}
