package programmers;

import java.util.Arrays;

public class Problem_서버증설횟수 {
    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        Solution solution = new Solution();
        int answer = solution.solution(players, 3, 5);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] players, int m, int k) {
            // 1. availablePlayerNumber[] 생성
            int[] currentServer = new int[24];
            // 2. players[] 순회
            int answer = 0;
            for (int t=0;t<24;t++){
                int currentPlayerNumber = players[t];
                if(currentPlayerNumber<(currentServer[t]+1)*m) continue;
                // 3. 만약 현재 시간의 수용가능한 인원보다 많다면 서버증설 후 카운트++


                // 4. 증설하고 현재포함 현재+K-1칸 만큼 수용가능한인원 업데이트
                int needServer = currentPlayerNumber/m-currentServer[t];


                for(int i=t;i<t+k;i++){
                    if(i>23)
                        break;
                    currentServer[i] += needServer;
                }

                answer += needServer;
            }

            return answer;
        }
    }
}
