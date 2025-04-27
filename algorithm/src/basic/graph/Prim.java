package basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// MST
// 정점(Vertex) 중심풀이
// 인접 행열, 인접 리스트 등을 이용해서 한 정점 -> 다른 정점 연결 관계 및 비용(가중치)을 이용
// 임의의 시작 정렬 정한다( 0 또는 1)
// 시작 정점에서부터 갈 수 있는 다른 정점들 중에 최소 비용의 정점 선택
// 시작 정점 포함 최소 비용의 정점 중에서 갈 수 있는 다른 정점들 중에 최소 비용의 정점
// 시작 정점 포함 이후의 과정에서 선택된 정점들 모두가 새로운 최소 비용의 정점을 선택하는 후보
// 위 과정을 선택된 정점의 수가 전체 정점의 수가 될 때까지 계속 진행
// 정점에서 다른 모든 연결된 정점 중 최소 비용의 정점 찾는 방법? : PriorityQueue 활용
// PriorityQueue에 담는 건 갈 수 있는 정점만 담고, 최소 비용의 정점을 찾아서 꺼내는 건 PriorityQueue가 처리
// 정점을 선택해 가는 과정에서 중복된 정점을 선택할 수 있다. <= visit[] 활용

/*
5
0 5 10 8 7
5 0 5 3 6
10 5 0 1 3
8 3 1 0 1
7 6 3 1 0
 */
public class Prim {
    static int V, sum;
    static int[][] matrix;
    static boolean[] visit;
    static PriorityQueue<Vertex> pq = new PriorityQueue<>((v1,v2)->v1.c-v2.c);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        matrix = new int[V][V];
        visit = new boolean[V];

        for(int i=0;i<V;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<V;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pq.offer(new Vertex(0,0));
        int cnt = 0;

        while (!pq.isEmpty()){
            Vertex vertex = pq.poll();
            if(visit[vertex.v]) continue;
            visit[vertex.v] = true;
            sum+=vertex.c;
            cnt++;
            if(cnt == V) break;

            for(int i=0;i<V;i++){
                int v = matrix[vertex.v][i];
                // 갈 수 있는 & 방문하지 않는
                if(v==0|| visit[i]) continue;
                pq.offer(new Vertex(i,v));
            }
        }

        System.out.println(sum);
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
