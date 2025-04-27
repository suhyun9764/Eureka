package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_표편집 {
    public static void main(String[] args) {
        int n = 8;  // 행 갯수
        int k = 2;  // 처음 선택된 행의 위치
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        Solution solution = new Solution();
        String answer = solution.solution(n, k, cmd);
        System.out.println(answer);
    }
    /*
    "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
    "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
    "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
    "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
     */


    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            int[] prev = new int[n];
            int[] next = new int[n];
            int cursor = k;
            Deque<Integer> deleteStack = new ArrayDeque<>();

            for(int i=0;i<n;i++){
                prev[i] = i-1;
                next[i] = i+1;
            }

            next[n-1] = -1;

            for (String str : cmd) {
                String[] orderAndNumber = str.split(" ");
                if (orderAndNumber[0].equals("U")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for(int i=0;i<number;i++){
                        cursor = prev[cursor];
                    }
                }
                if (orderAndNumber[0].equals("D")) {
                    int number = Integer.parseInt(orderAndNumber[1]);
                    for(int i=0;i<number;i++){
                        cursor = next[cursor];
                    }
                }
                if (orderAndNumber[0].equals("C")) {
                    deleteStack.push(cursor);
                    int prevIndex = prev[cursor];
                    int nextIndex = next[cursor];

                    if(prevIndex!=-1) next[prevIndex] = nextIndex;
                    if(nextIndex!=-1) prev[nextIndex] = prevIndex;

                    if(nextIndex!=-1){
                        cursor=nextIndex;
                    }else{
                        cursor=prevIndex;
                    }
                }
                if (orderAndNumber[0].equals("Z")) {
                    int latestDelete = deleteStack.pop();
                    int prevIndex = prev[latestDelete];
                    int nextIndex = next[latestDelete];

                    if(prevIndex!=-1) next[prevIndex] = latestDelete;
                    if(nextIndex!=-1) prev[nextIndex] = latestDelete;
                }
            }

            StringBuilder answer = new StringBuilder("O".repeat(n));
            while (!deleteStack.isEmpty()){
                int currentDelete = deleteStack.pop();
                answer.setCharAt(currentDelete,'X');
            }

            return answer.toString();
        }
    }
}
