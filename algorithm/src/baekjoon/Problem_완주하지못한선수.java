package baekjoon;

import java.util.HashMap;
import java.util.Map;

public class Problem_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        Solution solution = new Solution();
        String answer = solution.solution(participant, completion);
        System.out.println(answer);
    }

    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String,Integer> map = new HashMap<>();
            for (String name : participant) {
                map.put(name,map.getOrDefault(name,0)+1);
            }

            for (String name : completion) {
                map.put(name, map.get(name)-1);
            }

            for (String name : map.keySet()) {
                if(map.get(name)!=0)
                    return name;

            }
            return null;
        }
    }
}
