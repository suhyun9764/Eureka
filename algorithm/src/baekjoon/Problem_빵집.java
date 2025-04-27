package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_빵집 {
    static int R, C;
    static char[][] map;
    static int answer = 0;
    static int[] dy = {-1,0,1};

    public static void main(String[] args) throws IOException {
        setting();
        for(int i=0;i<R;i++){
            if(dfs(i,0))answer++;   // i번째 row에서 왼쪽부터 오른쪽으로 모두 연결에 성공했다
        }
        System.out.println(answer);
    }

    private static boolean dfs(int y, int x) {
       int nx = x+1;    // 옆으로 한칸 이동
       if(nx == C-1) return true;   // 빵집까지 도달

        // 우선 순위를 가진 delta 다음 방문진행
        // 다음 재귀호출의 결과가 true이면 성송이고 이 때 다음 delta방문하면 x
        for(int d=0;d<3;d++){
            int ny = y+dy[d];
            if(ny<0||ny>=R||map[ny][nx]=='x') continue;
            map[ny][nx] = 'x';  // 성공해도, 실패해도 다시 방문 x
            if(dfs(ny,nx)) return true; //현재 좌표에서 성공
        }

        // 현재 좌표에서 성공x
        return false;
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
}
