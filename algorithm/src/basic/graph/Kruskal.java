package basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// MST
// 간선(Edge) 중심 풀이
// 간선의 자료구조의 배열 또는 리스트
// 위 자료구조가 입력 테케에 친절하게 주어지면 그대로 간선 리스틀 만든다
// 만약 간선. 리스트가 아닌 입력 테케가 주어지면 그걸 이용해서 간선 리스트를 만들어야 한다.
// 간선 리스트를 최소비용 순으로 정렬<= 간선이 많은 문제는 불리
// 정렬 후 최소비용 간선을 계속 선택해서 간선이 연결하는 정점 선택
// cycle이 발생하는 간선 skip <= union find
// 선택한 간선의 수가 정점의 수 -1 개 될때까지 진행
public class Kruskal {
    static int V, E, sum;    // sum : MST 비용
    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V];
        edges = new Edge[E];

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1,v2,c);
        }

        // 풀이
        makeSet();

        Arrays.sort(edges,(e1,e2)-> e1.c-e2.c);
//        System.out.println(Arrays.toString(edges));

        // 크루스칼
        int cnt = 0;
        int edgesLen = edges.length;
        for(int i=0;i<edgesLen;i++){
            Edge edge = edges[i];
            // Cycle 체크하고 없으면 선택
            if(union(edge.v1, edge.v2)){
                System.out.println(edge.v1 +"->"+edge.v2+ " : " + edge.c);
                sum+=edge.c;
                cnt++;
                if(cnt == V-1)  break;  // 모든 간선을 선택한 경우
            }
        }
        System.out.println(sum);
    }

    // 간선 클래스 <= int[]로 대체가 가능
    static class Edge {
        int v1, v2, c;

        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", c=" + c +
                    '}';
        }
    }

    private static void makeSet() {
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    // 기존 union
//    private static void union(int x, int y) {
//        int px = findSet(x);
//        int py = findSet(y);
//
//        if (px < py) parent[py] = px;
//        else parent[x] = py;
//    }

    // 크루스칼은 findSet(v1) == findset(v2)를 이용해서 cycle체크하고 cycle이 안생기면 union()
    // findSet(v1), findSet(v2) 중복 실행이 되므로 크루스칼에 맞게 변형

    private static boolean union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(py == px) return false;  // 두 부모가 같다, 같은 집합이다. 이미 두 접점이 같은 집합으로 선택되어 있다.
        if (px < py) parent[py] = px;
        else parent[x] = py;

        return true;
    }

}
/*
정점수 간선수
v1 v2 가중치
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1
 */
