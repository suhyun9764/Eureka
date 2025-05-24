package programmers;

public class Problem_다음큰숫자 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int answer = solution.solution(78);
        System.out.println(answer);
    }

//    static class Solution {
//        public int solution(int n) {
//            String[] nBinaryArray = Integer.toBinaryString(n).split("");
//            int oneCount = countOne(nBinaryArray);
//
//            int current = n+1;
//            while(true){
//                String[] currentBinaryArray = Integer.toBinaryString(current).split("");
//                if(oneCount==countOne(currentBinaryArray))
//                    return current;
//
//                current++;
//            }
//        }
//
//        int countOne(String[] binaryString){
//            int count = 0;
//            for(String binary : binaryString){
//                if(binary.equals("1"))
//                    count+=1;
//            }
//
//            return count;
//        }
//    }

    static class Solution {
        public int solution(int n) {
            int oneCount = Integer.bitCount(n);
            int current = n+1;

            int answer = 0;
            while(true){
                if(Integer.bitCount(current)==oneCount){
                    answer = current;
                    break;
                }
                current++;
            }

            return answer;
        }
    }
}
