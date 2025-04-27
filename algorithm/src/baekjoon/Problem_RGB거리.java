package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 5번째 집 칠하는 최소 비용 = 5번째 집을
// 5번째 집을 R로 칠할 때 <= 4번째 집이 G일 때 최소비용과 4번째 집이 B일 때 최소비용
// 5번째 집을 G로 칠할 때 <= 4번째 집이 R일 때 최소비용과 4번째 집이 B일 때 최소비용
// 5번째 집을 B로 칠할 때 <= 4번째 집이 G일 때 최소비용과 4번째 집이 R일 때 최소비용
public class Problem_RGB거리 {
    static int N;
    static int[][] colorPrice;

    public static void main(String[] args) throws IOException {
        setting();
        System.out.println(dp());
    }

    private static long dp() {
        int[][] memo = new int[N + 1][3];
        memo[1][0] = colorPrice[1][0];
        memo[1][1] = colorPrice[1][1];
        memo[1][2] = colorPrice[1][2];

        // 두번째 집부터 dp 풀어간다
        for (int i = 2; i <= N; i++) {
            memo[i][0] = Math.min(memo[i-1][1],memo[i-1][2]) + colorPrice[i][0];
            memo[i][1] = Math.min(memo[i-1][0],memo[i-1][2]) + colorPrice[i][1];
            memo[i][2] = Math.min(memo[i-1][0],memo[i-1][1]) + colorPrice[i][2];
        }

        return Math.min(memo[N][2],Math.min(memo[N][0],memo[N][1]));
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        colorPrice = new int[N + 1][3];
        Arrays.fill(colorPrice[0], 0);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colorPrice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
