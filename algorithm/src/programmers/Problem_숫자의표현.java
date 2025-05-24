package programmers;

public class Problem_숫자의표현 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(15);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int n) {
            int answer = 1;
            int[] arr = new int[n+1];
            for(int i=1;i<n;i++){
                int sum = i;
                for(int j=i+1;j<n;j++){
                    sum+=j;
                    if(sum==n)
                        answer++;
                    if(sum>n)
                        break;
                }
            }

            return answer;
        }
    }
}
