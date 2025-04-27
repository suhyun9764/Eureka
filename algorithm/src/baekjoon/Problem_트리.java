    package baekjoon;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;

    import static baekjoon.Problem_BFS와DFS2.dfs;

    public class Problem_트리 {
        static int N;
        static int M;
        static List<Integer>[] nodes;
        static boolean visit[];
        static int currentNumber = 0;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            while (true){
                currentNumber++;
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                if(N==0&&M==0)
                    break;

                nodes = new ArrayList[N+1];
                visit = new boolean[N+1];

                for (int i = 1; i <= N; i++) {
                    nodes[i] = new ArrayList<>();
                }
                int answer = 0;
                for(int i=0;i<M;i++){
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    nodes[a].add(b);
                    nodes[b].add(a);
                }

                for(int i=1;i<=N;i++){
                    if(visit[i]) continue;
                    if(dfs(i,-1)) answer++;
                }

                System.out.print("Case "+currentNumber+": ");
                if(answer>1){
                    System.out.println("A forest of "+answer+" trees.");
                }else if(answer==1){
                    System.out.println("There is one tree.");
                }else{
                    System.out.println("No trees.");
                }

            }
        }

        private static boolean dfs(int node, int parent) {
            visit[node] = true;

            for (int child : nodes[node]) {
                if(visit[child]){
                    if(child!=parent) return false;
                }else{
                    if(!dfs(child,node))
                        return false;
                }

            }
            return true;
        }
    }
