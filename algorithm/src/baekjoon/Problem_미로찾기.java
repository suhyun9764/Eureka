package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_미로찾기 {
    static int N,M;
    static int[][] board;
    static boolean[][] visit;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = N*M;
        board = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        dfs(0,0,1);
        System.out.println(answer);
    }

    private static void dfs(int y, int x,int count) {
        visit[y][x] = true;
        if(y==N-1&&x==M-1){
            answer = Math.min(answer,count);
            visit[y][x] = false;
            return;
        }

        int[] dy= {-1,1,0,0};
        int[] dx ={0,0,-1,1};
        for(int i=0;i<4;i++){
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(ny<0||nx<0||ny>=N||nx>=M||board[ny][nx]==0||visit[ny][nx]) continue;
            dfs(ny,nx,count+1);
        }

        visit[y][x] = false;
    }
}
