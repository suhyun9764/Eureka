package basic.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFind {
    static int v, e;
    static int[] parent;
    /*
    6 4
    1 4
    2 3
    2 4
    5 6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v= Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 그래프 정점(1~6) 간 집합 표현
        // #1. 1차원 배열 생성
        parent = new int[v+1];  // 0 dummy

        // #2. 1차원 배열 초기화
        // 각 원소별 자기 자신이 대표원소가 되도록 ( 모든 정점이 각각 서로소인 집합 )
        makeSet();

        // #3. 주어진 테케에 맞게 union() 진행
        for(int i = 0 ;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x,y);
        }
        for (int i = 1; i < v; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 1; i < v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < v; i++) {
            System.out.print(findSet(i) + " ");
        }
        System.out.println();
    }

    private static void makeSet() {
        for(int i=1;i< parent.length;i++){
            parent[i] = i;
        }
    }

    // 전달된 x 원소의 대표원소 찾아서 return
    // path compression
    private static int findSet(int x){
        if(parent[x]==x) return x;
        return parent[x] = findSet(parent[x]);
    }

    private static void union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);

        if(px < py) parent[py] =px;
        else parent[x] = py;
    }
}
// 트리 : 노드(Node), 간선(Edge)
// 그래프 : 정점(Vertex), 간선(Edge)
/*
6 4 <- 정점(v), 간선(e)
1 4 <- 나머지는 합치는 연산
2 3
2 4
5 6
 */