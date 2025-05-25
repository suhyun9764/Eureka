package programmers;

import java.util.Arrays;

public class Problem_카펫 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(10, 2);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int allBoard = brown+yellow;
            int[] answer = new int[2];
            for(int i=3;i<=allBoard/2;i++){
                if(allBoard%i==0){
                    int j = allBoard/i;
                    if((i-2)*(j-2)==yellow){
                        answer[0] = Math.max(i,j);
                        answer[1] = Math.min(i,j);
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
