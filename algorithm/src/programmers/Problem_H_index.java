package programmers;

import java.util.Arrays;

public class Problem_H_index {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{3, 0, 6, 1, 5});
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            int answer = 0;
            int max = 0;
            for(int i=1;i<=citations.length;i++){
                for(int j=0;j<citations.length;j++){
                    if(citations[j]>=i){
                        int underNum = j;
                        int upNum = citations.length-underNum;
                        if(underNum<=i&&upNum>=i){
                            answer = Math.max(answer, i);
                        }
                    }

                }
            }

            return answer;
        }
    }
}
