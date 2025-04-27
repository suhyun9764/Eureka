package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        Solution solution = new Solution();
        int[] answer = solution.solution(prices);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int[][] pricesWithIndex = new int[prices.length][2];
            int[] answer = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                pricesWithIndex[i][0] = i;
                pricesWithIndex[i][1] = prices[i];
            }
            Deque<Integer> stack = new ArrayDeque<>();
            // 1. 인덱스 0부터 끝까지 순화
            for (int i = 0; i < prices.length; i++) {
                // 2. 스택이 비어있다면 그냥 집어 넣고 만약 자기보다 큰 값이 있다면 인덱스차이를 answer에 저장하고 pop후 push
                while (!stack.isEmpty()&&prices[stack.peek()]>prices[i]){
                    answer[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }

            while (!stack.isEmpty()){
                int currentIdx = stack.pop();
                answer[currentIdx] = prices.length-1-currentIdx;
            }
            return answer;

        }

        // O(N^2)
//        public int[] solution(int[] prices) {
//            int[] answer = new int[prices.length];
//
//            for(int i=0;i<prices.length;i++){
//                int currentPrice = prices[i];
//                for(int j=i+1;j<prices.length;j++){
//                    if(currentPrice>prices[j]) {
//                        answer[i] = j - i;
//                        break;
//                    }
//                }
//                if(answer[i]==0)
//                    answer[i] = prices.length-1-i;
//            }
//            return answer;
//        }
    }
}
