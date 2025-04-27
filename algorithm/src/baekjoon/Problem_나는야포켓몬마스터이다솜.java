package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_나는야포켓몬마스터이다솜 {
    static int N,M;
    static String[] arr;
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setting(br);

        solve(br);
    }

    private static void setting(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N+1];
        for(int i=1;i<N+1;i++){
            String name = br.readLine();
            arr[i] = name;
            map.put(name,i);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        for(int i=0;i<M;i++){
            String input = br.readLine();
            // 포켓몬 이름으로 들어왔을 때
            if(map.containsKey(input)) {
                System.out.println(map.get(input));
            }else{ // 숫자로 들어왔을 때
                System.out.println(arr[Integer.parseInt(input)]);
            }
        }
    }

}
