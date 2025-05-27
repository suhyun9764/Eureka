package programmers;

import java.util.Arrays;

public class Problem_최고의집합 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution(2, 9);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(int n, int s) {
            if(s<n)
                return new int[]{-1};

            int[] arr = new int[n];
            if(s%n==0){
                for(int i=0;i<n;i++){
                    arr[i] = s/n;
                }

                return arr;
            }

            int remain = s%n;
            for(int i=0;i<n-remain;i++){
                arr[i] = s/n;
            }

            for(int i=n-remain;i<n;i++){
                arr[i] = s/n+1;
            }

            return arr;
        }

    }
}
