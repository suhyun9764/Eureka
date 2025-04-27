package programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_짝지어제거하기 {
    public static void main(String[] args) {
        String s = "baabaa";
        String s1 = "cdcd";
        Solution solution = new Solution();
        int answer = solution.solution(s);
        System.out.println(answer);

    }

    static class Solution {
        public int solution(String s) {
            // 1. char배열에 한글자씩 저장하기
            char[] charArray = s.toCharArray();
            // 2. 인덱스 순회
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : charArray) {
                /*
             3. 스택안에 값이 있다면 최상단에 있는 값과 현재 인덱스의 값 비교
             같다면 최상단 값 삭제 및 현재값 스택에 담지 않음
             다르다면 현재값 스택에 추가
             */
                if (!stack.isEmpty() && stack.peek() == c) stack.poll();
                else {
                    stack.push(c);
                }
            }
            //4. 순회가 완료되었을 때 스택에 값이 없다면 1반환하고 있다면 0반환
            if (stack.isEmpty())
                return 1;

            return 0;

        }
    }
}
