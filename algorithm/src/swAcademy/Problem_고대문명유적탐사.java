package swAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_고대문명유적탐사 {
    static int K;   // 탐사의 반복 횟수
    static int M;   // 벽면에 적힌 유물 조각의 개수
    static int map[][] = new int[5][5];
    static Deque<Integer> stack = new ArrayDeque<>();
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        setting();
        simulate(K);
    }

    private static void simulate(int k) {
        for (int i = 0; i < k; i++) {   // k번 순회
            int result = getMaximumResult();
            if (result == 0)   // 해당턴에 얻을 수 있는 값이 없다면 종료
                break;

            System.out.println(result);
        }
    }

    private static int getMaximumResult() {
        PriorityQueue<ExploreResult> results = new PriorityQueue<>(new Comparator<ExploreResult>() {
            @Override
            public int compare(ExploreResult o1, ExploreResult o2) {
                if (o1.totalFoundNum == o2.totalFoundNum) {
                    if (o1.t == o2.t) {
                        if (o1.y == o2.y) {
                            return o1.x - o2.x;
                        } else {
                            return o1.y - o2.y;
                        }
                    } else {
                        return o1.t - o2.t;
                    }
                } else {
                    return o2.totalFoundNum - o1.totalFoundNum;
                }
            }
        });
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                // 1. 센터가 될 수 있는 점 모두 순회
                results = explore(i, j, results);
            }
        }

        return results.poll().totalFoundNum;
    }

    private static PriorityQueue<ExploreResult> explore(int y, int x, PriorityQueue<ExploreResult> results) {
        for (int t = 1; t <= 3; t++) {
            // 1. 회전하기
            int[][] tempMap = turn(y, x, t);
            // 2. 회전된 맵 탐색
            results.add(exploreEachMap(tempMap));
        }
        return results;
    }

    private static ExploreResult exploreEachMap(int[][] tempMap) {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        boolean[][] visit = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                List<int[]> sames = bfs(tempMap, visit, i, j, dy, dx);
                while(!sames.isEmpty()){
                    for (int[] same : sames) {
                        tempMap[same[0]][same[1]] = 0;

                    }
                }
            }
        }

        return null;
    }

    private static List<int[]> bfs(int[][] tempMap, boolean[][] visit, int i, int j, int[] dy, int[] dx) {
        if(visit[i][j])
            return null;
        // bfs
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visit[i][j] = true;
        int currentNum = tempMap[i][j];
        int cnt = 1;
        List<int[]> sames = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y= poll[0];
            int x =poll[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5 || visit[ny][nx] || tempMap[ny][nx] != currentNum)
                    continue;
                visit[ny][nx] = true;
                sames.add(new int[]{ny,nx});
                queue.offer(new int[]{ny,nx});
                cnt++;
            }
        }

        if (cnt >= 3) {
            for (int[] same : sames) {
                tempMap[same[0]][same[1]] = 0;
            }
        }

        return sames;
    }

    private static int[][] turn(int y, int x, int t) {
        /*
         static int[] dy = {-1,-1,-1,0,1,1,1,0};
         static int[] dx = {-1,0,1,1,1,0,-1,-1};
         */
        int[][] tempMap = new int[5][5];
        for (int i = 0; i < 5; i++) {
            tempMap[i] = Arrays.copyOf(map[i], 5);
        }
        if (t == 1) {   // 90도 회전
            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (d - 2 >= 0) {
                    d -= 2;
                } else {
                    d = 8 + (d - 2);
                }
                int cy = y + dy[d];
                int cx = x + dx[d];

                tempMap[ny][nx] = map[cy][cx];
            }
        } else if (t == 2) { // 180도 회전
            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (d - 4 >= 0) {
                    d -= 4;
                } else {
                    d = 8 + (d - 4);
                }
                int cy = y + dy[d];
                int cx = x + dx[d];

                tempMap[ny][nx] = map[cy][cx];
            }
        } else { // 270도 회전
            for (int d = 0; d < 8; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (d - 6 >= 0) {
                    d -= 6;
                } else {
                    d = 8 + (d - 6);
                }
                int cy = y + dy[d];
                int cx = x + dx[d];

                tempMap[ny][nx] = map[cy][cx];
            }
        }
        return tempMap;
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stack.push(Integer.valueOf(st.nextToken()));
        }
    }

    static class ExploreResult {
        int y;  //중심 y
        int x;  //중심 x
        int t;  //회전 각도 1: 90, 2: 180, 3: 270
        int totalFoundNum;

        public ExploreResult(int y, int x, int t, int totalFoundNum) {
            this.y = y;
            this.x = x;
            this.t = t;
            this.totalFoundNum = totalFoundNum;
        }
    }
}
