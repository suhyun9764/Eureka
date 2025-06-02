package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Problem_튜플 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answer = solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(String s) {
            s = s.substring(2, s.length() - 2);
            String[] tuples = s.split("},\\{");
            Arrays.sort(tuples, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.split(",").length - o2.split(",").length;
                }
            });

            int length = tuples[tuples.length - 1].split(",").length;
            int[] answer = new int[length];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < tuples.length; i++) {
                String tuple = tuples[i];
                String[] values = tuple.split(",");
                for (String strValue : values) {
                    int value = Integer.parseInt(strValue);
                    if (set.contains(value)) continue;
                    set.add(value);
                    answer[i] = value;
                    break;
                }
            }

            return answer;
        }

    }
}