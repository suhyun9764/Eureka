package stackqueue;

import java.util.Arrays;
import java.util.Comparator;

public class Problem_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        Solution solution = new Solution();
        int answer = solution.solution(triangle);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[][] triangle) {
            for(int i=1;i<triangle.length;i++){
                for(int j=0;j<triangle[i].length;j++){
                    if(j==0)
                        triangle[i][j] += triangle[i-1][0];
                    else if(j==triangle[i].length-1)
                        triangle[i][j] += triangle[i-1][triangle[i-1].length-1];
                    else {
                        triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
                    }
                }
            }

            int max = 0;
            for (int i : triangle[triangle.length - 1]) {
                max = Math.max(max,i);
            }
            return max;
        }
    }
}
