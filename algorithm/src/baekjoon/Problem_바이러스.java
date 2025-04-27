package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_바이러스 {
    static int N, M;
    static ArrayList<Integer>[] network;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        network = new ArrayList[N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            network[i] = new ArrayList<>();
        }
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }

        int answer = dfs(1, 0);
        System.out.println(answer);
    }

    private static int dfs(int current, int count) {
        visit[current] = true;
        ArrayList<Integer> myNetWork = network[current];
        for (Integer i : myNetWork) {
            if(visit[i])continue;
            count = dfs(i,count+1);
        }

        return count;

    }
}
