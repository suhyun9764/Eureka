package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_올바른괄호2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean solution = Solution.solution(br.readLine());
        System.out.println(solution);
    }

    class Solution {
        static boolean solution(String s) {
            char[] charArray = s.toCharArray();
            int len = charArray.length;
            int xCnt = 0;
            for(int i=0, oi=0;i<len;i++){
                if(charArray[i]==')'){
                    if(charArray[oi] != '(') return false;

                    // 두 괄호가 일치
                    charArray[i] = 'X';
                    charArray[oi] = 'X';
                    xCnt+=2; // 일치해서 처리된 항목수 2 증가

                    while (oi>0 && charArray[oi]=='X') oi--;
                }else{  // 여는 괄호
                    oi = i;
                }
            }

            return xCnt == len;
        }
    }
}

