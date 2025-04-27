package basic.graph;

// 한 정점에서부터 그래프의 다른 정점으로 가는 최소 비용
// 정점(Vertex) 중심풀이
// 한 정점으로부터 다른 모든 정점으로 가는 최소 비용을 관리하는 배열 int[] cost
// 이 배열을 초기값을 충분히 큰 값으로 설정, 이후 알고리즘을 진행하면서 시작 정점으로부터 비용을 갱신 진행
// 알고리즘 처리가 종료되면 cost[]의 값이 최소 비용
// 시작 정점 0, 5개의 정점이 있다고 치면 cost : {0,4,6,2,7}
// 0 - > 1 : 4, 0 - > 4 : 7

// 정점에서 다른 모든 연결된 정점 중 최소 비용의 정점 찾는 방법? : PriorityQueue 활용
// PriorityQueue에서 꺼낸 정점으로부터 갈 수 있는 다른 정점을 통해 cost 배열이 갱신될 수 있으면 갱신하고 갱신된 정점을  다시 PQ에 넣는다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0
==> 8
4
0 94 53 16
79 0 24 18
91 80 0 98
26 51 92 0
==> 16
7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0
==> 14
 */
public class Dijkstra {
    static int V, start, end;
    static int[][] matrix;
//    static boolean[] visit;  // visit<= 비용 비교를 통해서 visit 처리
    static PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>((v1, v2)->v1.c-v2.c);

    static int[] cost;  // 다익스트라의 핵심 자료 구조 ( 각 index 가 정점을 표현, 계속 최소비용으로 갱신되면서 정답을 보관
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        start = 0;
        end = V-1;
        matrix = new int[V][V];
        cost = new int[V];

        for(int i=0;i<V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<V;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(cost,INF);  // 충분히 큰 값으로 초기화

        // 시작 정점 (Start)부터 시작
        cost[start] = 0;
        pq.offer(new Vertex(start,0));

        while (!pq.isEmpty()){
            Vertex vertex = pq.poll();

            // visit 체크 (별도의 visit[] 이용해서 풀이 가능)
            // cost[] 갱신여부 비용비교를 통해서 처리
            // 이미 방문 그리고 비용이 . 높기때문에 필요 x
            if(cost[vertex.v] < vertex.c) continue;

            // 시작 정점(start) ~> vertex.v로부터 cost 비용 갱신될 수 있다.
            for (int i=0;i<V;i++){
                // 꺼낸 정점으로부터 갈 수 있는 정점을 고려
                if(matrix[vertex.v][i]==0) continue;
                if(cost[i] > vertex.c + matrix[vertex.v][i]){
                    cost[i] = vertex.c + matrix[vertex.v][i];
                    pq.offer(new Vertex(i,cost[i]));    // start에서 i 정점으로 가는 최소 비용을 이용해서 객체 생성
                }
            }
        }
        System.out.println(cost[end]);
    }

    static class Vertex {
        int v, c;    // 정점 객체가 생성되는 시점에 PQ에서 꺼낸 정점으로 갈 수 있는 다른 정점

        Vertex(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "v=" + v +
                    ", c=" + c +
                    '}';
        }
    }
}
