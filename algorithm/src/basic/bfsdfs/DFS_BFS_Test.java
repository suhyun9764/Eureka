package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.Queue;

// 2차원 배열 상하좌우 탐색을 통한 dfs, bfs
// 한번 방문한 좌표는 다시 방문하지 않는다
public class DFS_BFS_Test {
    static int[][] map = {
            {0, 0, 0, 0, 0, 0, 0},  // dummy 각 열, 행의 0번째는 사용 x
            {0, 11, 12, 13, 14, 15, 16},
            {0, 21, 22, 23, 24, 25, 26},
            {0, 31, 32, 33, 34, 35, 36},
            {0, 41, 42, 43, 44, 45, 46},
            {0, 51, 52, 53, 54, 55, 56},
            {0, 61, 62, 63, 64, 65, 66},
    };

    // 상 - 하 - 좌 - 우 순서
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static boolean[][] visit;

    public static void main(String[] args) {
        visit = new boolean[7][7];  // 0 dummy
//        dfs(3, 3);
        System.out.println();
        bfs(3, 3);

    }

    static void dfs(int y, int x) {
        // 해당 좌표에서 할 일 진행
        visit[y][x] = true;
        System.out.println(map[y][x]);

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visit[ny][nx]) continue;
            dfs(ny, nx);
        }
    }

    static void bfs(int y, int x) {
        // 시작 Node를 큐에 넣고 출발
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y,x));
        visit[y][x] = true;

        while (!queue.isEmpty()){
            Node node= queue.poll();

            System.out.println(node);
            // 꺼낸 노드 객체로부터 갈 . 있는
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 1 || nx < 1 || ny >= 7 || nx >= 7 || visit[ny][nx]) continue;
                queue.offer(new Node(ny,nx));
                visit[ny][nx] = true;
            }
        }
    }

    static class Node{
        int y,x;
        Node(int y, int x){
            this.y =y; this.x=x;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
