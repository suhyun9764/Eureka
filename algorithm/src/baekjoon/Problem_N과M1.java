package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_N과M1 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] result = new int[M];
        boolean[] visit = new boolean[N + 1];
        dfs(0, visit, result);

    }

    private static void dfs(int count, boolean[] visit, int[] result) {
        if (count == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            result[count] = i;
            dfs(count + 1, visit, result);
            visit[i] = false;
            result[count] = 0;
        }
    }

}
