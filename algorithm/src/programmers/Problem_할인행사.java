package programmers;

import java.util.HashMap;
import java.util.Map;

public class Problem_할인행사 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = solution.solution(want, number, discount);
        System.out.println(answer);
    }

    static class Solution {
        static Map<String, Integer> products = new HashMap<>();
        static int[] currentProductNumber;
        static int answer = 0;

        public int solution(String[] want, int[] number, String[] discount) {
            currentProductNumber = new int[want.length];
            // 1. 원하는 품목 인덱스 맵에 저장하기
            saveProducts(want);
            // 초기 10일 탐색
            initCurrentPorductNumber(discount);
            // 원하는 품목을 다 살 수 있는지 체크
            checkCanStart(number);
            // 2. discount 10개씩 슬라이딩 윈도우
            for(int startIdx = 0;startIdx<discount.length-10;startIdx++){
                int endIdx = startIdx+10;
                if(products.containsKey(discount[startIdx])){
                    // startIdx가 products에 있다면 currentProductNumber[startIdx품목]--;
                    int productIdx = products.get(discount[startIdx]);
                    currentProductNumber[productIdx]--;
                }
                if(products.containsKey(discount[endIdx])){
                    // endIdx가 products에 있다면 currentProductNumber[endIdx품목]++;
                    int productIdx = products.get(discount[endIdx]);
                    currentProductNumber[productIdx]++;
                }
                checkCanStart(number);
            }

            return answer;
        }

        private void checkCanStart(int[] number) {
            int cnt = 0;
            for(int i = 0; i< number.length; i++){
                if(currentProductNumber[i]>= number[i])
                    cnt++;
            }
            if(cnt==number.length)
                answer++;
        }

        private void saveProducts(String[] want) {
            int productIdx = 0;
            for (String productName : want) {
                products.put(productName, productIdx++);
            }
        }

        private void initCurrentPorductNumber(String[] discount) {
            for(int i=0;i<10;i++){
                String productName = discount[i];
                if (products.containsKey(productName)) {
                    currentProductNumber[products.get(productName)]++;
                }
            }
        }
    }
}
