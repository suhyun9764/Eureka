package programmers;

public class Problem_점프와순간이동 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(5);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;
            while(n>0){
                if(n%2==1)
                    answer++;

                n /= 2;
            }

            return answer;
        }
    }
}
