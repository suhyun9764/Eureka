package programmers;

import java.util.HashSet;
import java.util.Set;

public class Problem_폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        Solution solution = new Solution();
        int answer = solution.solution(nums);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int n = nums.length/2;
            if(n>=set.size())
                return set.size();

            return n;
        }
    }
}
