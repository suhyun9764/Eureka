package programmers;

import java.util.HashMap;
import java.util.Map;

public class Problem_의상 {
    public static void main(String[] args) {

    }

    static class Solution {
        static Map<String,Integer> map;
        public int solution(String[][] clothes) {
            map = new HashMap<>();

            for(String[] c : clothes){
                String name = c[0];
                String category = c[1];
                if(map.containsKey(category)){
                    map.put(category,map.get(category)+1);
                }else{
                    map.put(category,1);
                }
            }
            int answer = 1;
            // 옷의 경우의 수
            for(int value : map.values()){
                answer *= value+1;
            }

            return answer-1;
        }

    }
}
