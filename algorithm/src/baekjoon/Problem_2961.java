package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2961 {
    public static void main(String[] args) throws IOException {
        /*
        1. 재료의 갯수 N 입력받기
        2. N개의 줄에 신맛 S와 B 각각 입력받기
        3. 신맛과 쓴맛의 차이가 가장 작게 조합하기
        신맛 = 사용한 재료의 신맛의 곱
        쓴맛 = 사용한 재료의 쓴맛의 합
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new int[]{S,B});
        }

        for(int i=0;i<N;i++){   // 각 재료 인덱스 순회
            for(int num=0;num<N-i;num++) {  // 재료 갯수

            }
        }
    }
}
