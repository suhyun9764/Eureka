package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Problem_섬연결하기 {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        };

        Solution solution = new Solution();
        int answer = solution.solution(n, costs);
        System.out.println(answer);
    }

    static class Solution {
        static int[] parents;
        public int solution(int n, int[][] costs) {
            int answer = 0;
            parents = new int[n];
            for(int i=0;i<n;i++){
                parents[i] = i;
            }
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            for(int i=0;i<costs.length;i++){
                int[] currentCosts = costs[i];
                int a = currentCosts[0];
                int b = currentCosts[1];

                int cost = currentCosts[2];
                if(find(a)!=find(b)){
                    union(a,b);
                    answer+=cost;
                }
            }

            return answer;
        }

        void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA!=rootB){
                parents[rootB] = rootA;
            }
        }

        int find(int x){
            if(parents[x]!=x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }


}
