package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_Nqueen {
    static int answer = 0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] board = new int[N];
        dfs(0,board);
        System.out.println(answer);
    }

    private static void dfs(int row, int[] board) {
        if(row==N) {
            answer += 1;
            return;
        }

        for(int j=0;j<N;j++){
            if(validateIsPossible(row,j,board)) {
                board[row] = j;
                dfs(row + 1,board);
            }
        }


    }

    private static boolean validateIsPossible(int row, int j,int[] board) {

        if(row==0)
            return true;

        // 같은 라인이 있는지
        for(int i=0;i<row;i++) {
            if (j == board[i])
                return false;


            // 대각으로 겹치는지
            if (j + (row - i) == board[i] || j - (row - i) == board[i])
                return false;
        }

        return true;
    }
}
