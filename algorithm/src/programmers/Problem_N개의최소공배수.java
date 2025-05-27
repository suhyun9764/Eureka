package programmers;

import java.util.Arrays;

public class Problem_N개의최소공배수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{1, 2, 3});
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] arr) {
            // arr 오름차순 정렬
            Arrays.sort(arr);
            // arr 순회
            int answer = arr[0];
            for(int i=1;i<arr.length;i++){
                int salt = 2;
                int min = Math.min(answer,arr[i]);
                int max = Math.max(answer,arr[i]);
                // arr[i+1]%arr[i] ==0 이될때까지 arr * 2,3 ..
                int buff = max;
                while(buff%min!=0){
                    buff = max*salt;
                    salt++;
                }
                // 최소공배수 업데이트
                answer = buff;
            }

            return answer;
        }
    }
}
