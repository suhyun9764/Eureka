package programmers;

import java.util.*;

public class Problem_야근지수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(4, new int[]{4, 3, 3});
        System.out.println(answer);
    }

    static class Solution {
        public long solution(int n, int[] works) {
            // 우선순위큐(reverseOrder)에 작업저장
            Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
            for(int work : works){
                queue.add(work);
            }
            // n번만큼 순회
            // while(n>0){
            //     int currentWork = queue.poll();
            //     if(currentWork==0) break;
            //     int nextWork = queue.peek();
            //     int diff = 0;
            //     if(currentWork==nextWork){
            //         diff =Math.min(n,1);
            //     }else{
            //         diff = Math.min(n,currentWork-nextWork);
            //     }
            //     queue.add(currentWork-diff);
            //     n-=diff;
            // }
            for(int i=0;i<n;i++){
                int currentWork = queue.poll();
                if(currentWork==0)
                    break;
                // 큐에서 poll후 해당값 -1(0인 경우는 무시)
                // 다시 큐에 넣기
                queue.add(currentWork-1);
            }
            long answer = 0;
            // 순회 종료 후 큐에남은것이 없을 떄까지 poll후 해당값 제곱하여 answer에 더하기
            while(!queue.isEmpty()){
                int currentWork = queue.poll();
                answer += currentWork*currentWork;
            }
            return answer;

        }
    }
}
