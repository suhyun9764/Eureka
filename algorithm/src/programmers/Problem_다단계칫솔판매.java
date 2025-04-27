package programmers;

    import java.util.*;

public class Problem_다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        Solution solution = new Solution();
        int[] result = solution.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));
    }

    static class Solution {
        static int[] totalAmount;
        static int[] parents;
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            // 1. 직원 명단 맵으로 정리
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < enroll.length; i++) {
                map.put(enroll[i], i);
            }

            // 2. 각 자식 저장, 말단 사원 구하기
            parents = new int[enroll.length];

            for (int i = 0; i < referral.length; i++) {
                String parent = referral[i];
                if (parent.equals("-"))
                    parents[i] = -1;
                else {
                    Integer parentNumber = map.get(parent);
                    parents[i] = parentNumber;
                }
            }

            // 3. 정산표 만들고 초기화
            totalAmount = new int[enroll.length];
            Arrays.fill(totalAmount, 0);

            for(int i=0;i<seller.length;i++){
                String currentName = seller[i];
                int currentIdx = map.get(currentName);
                int money = amount[i] * 100;
                while (currentIdx!=-1){
                    int give = money/10;
                    int keep = money-give;
                    totalAmount[currentIdx]+=keep;
                    currentIdx = parents[currentIdx];
                    money = give;
                }
            }

            return totalAmount;
        }

    }
}
