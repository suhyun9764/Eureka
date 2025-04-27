package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_Z {
    public static void main(String[] args) throws IOException {
        // 1. N, R(세로), C(가로) 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int answer = 1;
        for(int i=N;i>0;i--){
            // 몇 사분면에 있는지 판단
            int boardLength = (int)Math.pow(2,N);
            int rPosition = r%boardLength;
            int cPosition = c%boardLength*boardLength;

            if(rPosition==0&&cPosition==0)
                answer*=1;
            else if(rPosition==0&&cPosition==1)
                answer*=2;
        }
    }
}
