package programmers;

import javax.swing.plaf.IconUIResource;

public class Problem_네트워크 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        Solution solution = new Solution();
        int answer = solution.solution(3, array);
        System.out.println(answer);
    }

    static class Solution {
        static boolean[] visit;
        static int answer=0;
        public int solution(int n, int[][] computers) {
            visit = new boolean[computers.length];
            for(int i=0;i<computers.length;i++){
                if(visit[i]) continue;
                dfs(i,computers);
                answer++;
            }
            return answer;
        }

        private void dfs(int i,int[][] computers) {
            visit[i] = true;
            int[] myComputers = computers[i];
            for(int c=0;c<computers.length;c++){
                if(c==i) continue;
                if(myComputers[c]==0)continue;
                if(visit[c])continue;
                dfs(c,computers);
            }
        }
    }
}
