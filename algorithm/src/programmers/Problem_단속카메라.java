package programmers;

import java.util.Arrays;

public class Problem_단속카메라 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int solution(int[][] routes) {
            Arrays.sort(routes,(x,y)->Integer.compare(x[1],y[1]));
            int answer = 0;
            int lastCam = -30001;

            for(int[] route : routes){
                if(route[0]<=lastCam&&route[1]>=lastCam) continue;
                lastCam=route[1];
                answer++;
            }
            return answer;
        }
    }
}
