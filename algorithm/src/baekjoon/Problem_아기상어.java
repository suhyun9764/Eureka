//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Problem_아기상어 {
//    static int N;
//    static int[][] Map;
//    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//    static int Y, X;
//    static boolean[][] visit;
//    static int count = 0;
//    static int time = 0;
//    static int size = 2;
//    static Queue<Node> queue = new ArrayDeque<>();
//
//    public static void main(String[] args) throws IOException {
//        setting();
//        while (true){
//            int cnt = bfs();
//            if(cnt==0) break;
//            count += cnt;
//        }
//
//
//    }
//
//    static int bfs(){
//        // 먹이 후보
//        int minDis = Integer.MAX_VALUE; // bfs() 과정에서 먹을 수 있는 물고리르 찾으면 갱신
//        int minY = Integer.MAX_VALUE;
//        int minX = Integer.MAX_VALUE;
//
//        // visit 초기화
//        visit[Y][X] = true;
//        queue.offer(new Node(Y,X,0));
//
//        while(!queue.isEmpty()){
//            Node node = queue.poll();
//            int y = node.y;
//            int x = node.x;
//            int d = node.d;
//
//            if(Map[y][x]<size&&Map[y][x]!=0){
//                if(d<minDis){   // 거리가 더 작으면
//                    minDis =d ;
//                    minY = y;
//                    minX = x;
//                }else if(d==minDis) {    // 거리가 같으면
//                    if(y<minY){
//                        minDis =d;
//                        minY = y;
//                        minX =x;
//                    }else if(y==minY){
//                        if(x<minX){
//                            minDis=d;
//                            minY = y;
//                            minX = x;
//                        }
//                    }
//                }
//            }
//
//            // 가지 치기
//            if(d +1 >=minDis) continue;
//
//            // 4방 탐색
//            for(int i=0;i<dx.length;i++){
//                int ny = y+dy[i];
//                int nx = x+dx[i];
//
//                if(ny<0||nx<0||ny>=N||nx>=N|visit[ny][nx]||Map[ny][nx]>size) continue;
//                visit[ny][nx] = true;
//                queue.offer(new Node(ny,nx,node.d+1));
//            }
//        }
//
//        if(minDis==Integer.MAX_VALUE) return 0;
//        else{
//            count++;
//            if(count==size) {
//                size++;
//                count=0;
//            }
//            Map[minY][minX] = 0; // 먹은 물고기자리
//
//        }
//
//    }
//
//    private static void setting() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        Map = new int[N][N];
//        visit = new boolean[N][N];
//
//        StringTokenizer st;
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                Map[i][j] = Integer.parseInt(st.nextToken());
//                if (Map[i][j] == 9) {
//                    Y = i;
//                    X = j;
//                    visit[Y][X] = true;
//                }
//            }
//        }
//    }
//
//    static class Node{
//        int x,y,d;
//
//        public Node(int x, int y, int d) {
//            this.x = x;
//            this.y = y;
//            this.d = d;
//        }
//    }
//}
