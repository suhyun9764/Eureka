package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_최소비용구하기_2 {
    static int N,M,START,END;
    static int[][] map;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        setting();

    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        cost = new int[N+1];
        Arrays.fill(cost,Integer.MAX_VALUE);

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[start][end] = cost;
        }

        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
    }

    static class Vertex{
        int v;
        int c;

        public Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
