package programmers;

import java.util.*;

public class Problem_귤고르기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            List<int[]> list = new ArrayList<>();
            Map<Integer,Integer> map = new HashMap<>();
            for(int t : tangerine){
                if(map.containsKey(t)){
                    list.get(map.get(t))[1]++;
                }else{
                    list.add(new int[]{t,1});
                    map.put(t,list.size()-1);
                }
            }

            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1]-o1[1];
                }
            });

            int answer =0;
            for(int i=0;i<list.size();i++){
                if(k<=0)
                    break;

                k-=list.get(i)[1];
                answer++;
            }

            return answer;
        }
    }
}
