package basic.bfsdfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class DFS_BFS_Test1 {
    static boolean[][] matrix;
    static boolean[]visit;

    public static void main(String[] args) {
        matrix = new boolean[5][5]; // 0 dummy
        // 간선
        // 1 -> 2, 4
        // 2 -> 3, 4
        // 3 -> 2
        // 4 -> 3
        matrix[1][2] = true;
        matrix[1][4] = true;
        matrix[2][3] = true;
        matrix[2][4] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;

        // visit 초기화
        visit = new boolean[5];

//        dfs(1); // 시작 정점이 1번
        bfs(1);
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(v);
        visit[v] = true;


        while (!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex+" -> ");
            for(int i=1;i<matrix.length;i++){
                if(matrix[vertex][i]==true&&!visit[i]){
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }


    }

    private static void dfs(int v) {
        visit[v] = true;
        System.out.println(v + " ->");

        for(int i=1;i<matrix.length;i++){
            if(matrix[v][i]==true&&visit[i]==false){
                dfs(i);
            }
        }
    }
}
