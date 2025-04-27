package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Problem_완전범죄 {
    public static void main(String[] args) {
        int[][] info = {{3,3},{3,3}};
        Solution solution = new Solution();
        int answer = solution.solution(info, 6, 1);
        System.out.println(answer);
    }

    static class Solution {
        static int aMin;
        static int[][] INFO;
        static int N,M;
        static boolean inValid = false;

        public int solution(int[][] info, int n, int m) {
            aMin = n;
            INFO = info;
            N = n;
            M = m;
            Arrays.sort(INFO, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });
            combine(0,0,0);
            if(aMin==N)
                return -1;
            return aMin;
        }

        private void combine(int a, int b, int product) {
            if(a>=N||b>=M)
                return;

            if(a>=N&&b>=M){
                inValid = true;
                return;
            }

            if(product== INFO.length){
                if(a<aMin)
                    aMin=a;

                return;
            }


            combine(a+INFO[product][0],b,product+1);
            if(inValid)
                return;
            combine(a,b+INFO[product][1],product+1);
        }
    }

}
