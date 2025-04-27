package programmers;

import java.util.Arrays;

public class Problem_구명보트 {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int start = 0;
            int end = people.length - 1;
            int answer = 0;
            while (start <= end) {
                if (people[start] + people[end] <= limit) {
                    start++;
                }
                end--;
                answer++;
            }
            return answer;
        }
    }
}
