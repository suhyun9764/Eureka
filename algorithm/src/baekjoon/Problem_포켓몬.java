package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem_포켓몬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<Integer,String> pocketmonsByNumber = new HashMap<>();
        Map<String,Integer> pocketmonsByName = new HashMap<>();

        for(int i=0;i<N;i++){
            String name =br.readLine();
            pocketmonsByNumber.put(i+1,name);
            pocketmonsByName.put(name,i+1);

        }

        for(int i=0;i<M;i++){
            String problem = br.readLine();
            // 숫자일 경우
            int intProblem = Integer.parseInt(problem);
            System.out.println();
            // 문자일 경우
        }

    }
}
