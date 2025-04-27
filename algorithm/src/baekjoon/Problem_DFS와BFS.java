package baekjoon;

import basic.input.BufferedReaderTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_DFS와BFS {
    static int N,M,V;
    static boolean[] visit;
    static List<Integer>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        Arrays.fill(visit,false);
        nodes = new List[N+1];
        for(int i=1;i<nodes.length;i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        for(int i=1;i<nodes.length;i++){
            Collections.sort(nodes[i]);
        }

        dfs(V);
        Arrays.fill(visit,false);
        System.out.println();
        bfs(V);


    }

    private static void dfs(int current) {
        visit[current] = true;
        System.out.print(current+" ");
        List<Integer> myNodes = nodes[current];
        for (Integer myNode : myNodes) {
            if(!visit[myNode]){
                dfs(myNode);
            }
        }
    }

    private static void bfs(int current) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(current);
        visit[current] = true;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.print(poll+" ");
            visit[poll] = true;
            List<Integer> myNodes = nodes[poll];
            for (Integer myNode : myNodes) {
                if(!visit[myNode]){
                    queue.offer(myNode);
                    visit[myNode] = true;
                }

            }
        }
    }
}
