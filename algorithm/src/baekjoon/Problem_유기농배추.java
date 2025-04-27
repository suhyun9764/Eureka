package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_유기농배추 {
    static int T,M,N,K;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T= Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N= Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];
            for(int b=0;b<N;b++){
                Arrays.fill(map[b],0);
            }
            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int answer = getAnswer();
            System.out.println(answer);
        }

    }

    private static int getAnswer() {
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0||visit[i][j]) continue;
                bfs(i,j);
                count++;
            }
        }
        return count;
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i,j});
        visit[i][j] = true;
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            int[] dy = {-1,1,0,0};
            int[] dx = {0,0,-1,1};
            for(int d=0;d<4;d++){
                int ny = y+dy[d];
                int nx = x+dx[d];

                if(ny<0||nx<0||ny>=N||nx>=M||map[ny][nx]==0||visit[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.offer(new int[]{ny,nx});

            }
        }
    }
}
