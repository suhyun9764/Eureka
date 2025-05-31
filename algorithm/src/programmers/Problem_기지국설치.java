package programmers;

public class Problem_기지국설치 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(11, new int[]{4,11}, 1);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int emptyStart = 1;
            int answer = 0;

            for (int station : stations) {
                int stationStart = Math.max(1, station - w);
                int stationEnd = Math.min(n, station + w);

                int totalEmpty = stationStart - emptyStart;
                if (totalEmpty > 0) {
                    answer += (totalEmpty + 2 * w) / (2 * w + 1);
                }

                emptyStart = stationEnd + 1;
            }

            // 마지막 기지국 이후 남은 구간
            if (emptyStart <= n) {
                int totalEmpty = n - emptyStart + 1;
                answer += (totalEmpty + 2 * w) / (2 * w + 1);
            }

            return answer;
        }
    }

}
