package basic.delta;

import java.util.Arrays;

// 여러칸
// 특정 위치에서 4방 탐색을 진행하는 경우, if-else if -else ....<=코드의 길이가 길어짐
// =>> 실수하기 쉬움

public class DeltaTest2 {
    static char[][] map = new char[5][5];
    public static void main(String[] args) {
        char ch = 'A';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }
        // 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        int y = 2;
        int x = 2;
//        System.out.println(map[y][x]);

        print4x(y,x);
    }
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    // delta는 이동방향에 대해서 y의 변화량, x의 변화량을 미리 배열에 저장하고 이를 활용해서 새로운 이동(상,하,좌,우) 자표를 구하는 방식
    private static void print4x(int y, int x) {
        for(int d=0;d<4;d++){
            int ny = y;
            int nx = x;

            while (true){
                ny = ny + dy[d];
                nx = nx + dx[d];

                if(ny<0||nx<0||ny>=5||nx>=5)break;

                System.out.println(map[ny][nx]);
            }

            // y,x에서 현재 d 방향으로 이동한 새로운 좌표 계산
        }
    }
}
