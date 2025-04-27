//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
//
//public class Problem_최소스패닝트리_prim {
//    static int V,E;
//    static List<Integer>[] board;
//    static boolean[] visit;
//    static int sum,cnt = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//
//        board = new List[V+1];
//        visit = new boolean[V+1];
//
//        // 인접 리스트
//        for(int i=0;i<E;i++){
//            st = new StringTokenizer(br.readLine());
//            int v1 = Integer.parseInt(st.nextToken());
//            int v2 = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());
//            board[v1][v2] = c;
//            board[v2][v1] = c;
//        }
//
//        PriorityQueue<Vertex> pq = new PriorityQueue<>((v1,v2)->v1.c-v2.c);
//        pq.offer(new Vertex(1,0));
//
//        while (!pq.isEmpty()){
//            Vertex currentVertex = pq.poll();
//            sum+=currentVertex.c;
//            visit[currentVertex.v] = true;
//            cnt+=1;
//            if(cnt==V)
//                break;
//            for(int i=1;i<V+1;i++){
//                if(board[currentVertex.v][i]!=0&&!visit[i]){
//                    pq.offer(new Vertex(i,board[currentVertex.v][i]));
//                }
//            }
//        }
//
//        System.out.println(sum);
//    }
//
//    static class Vertex{
//        int v;
//        int c;
//
//        public Vertex(int v, int c) {
//            this.v = v;
//            this.c = c;
//        }
//    }
//}
