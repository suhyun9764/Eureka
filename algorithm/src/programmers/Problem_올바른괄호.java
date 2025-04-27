package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_올바른괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean solution = Solution.solution(br.readLine());
        System.out.println(solution);
    }

    class Solution {
        static boolean solution(String s) {
            char[] charArray = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < charArray.length; i++) {
                char current = charArray[i];
                if (current == '(') {
                    stack.push(current);
                } else {
                    if (stack.isEmpty())
                        return false;
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                return true;

            return false;
        }
    }
}

