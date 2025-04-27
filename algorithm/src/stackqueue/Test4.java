package stackqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

public class Test4 {
    public static void main(String[] args) {
        // 사용자 정의 클래스 대신 int[]를 stack이나 queue 활용

        // stack
        {
            Deque<int[]> stack = new ArrayDeque<>();
            stack.push(new int[]{3, 0, 4});
            stack.push(new int[]{2, 8, 1});
            stack.push(new int[]{1, 6, 3});
            stack.push(new int[]{5, 5, 10});


            System.out.println(Arrays.toString(stack.pop()));
            System.out.println(Arrays.toString(stack.peek()));
            stack.push(new int[]{9, 0, 3});

            while (!stack.isEmpty()) {
                System.out.println(Arrays.toString(stack.pop()));
            }
        }
    }

    {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{3, 0, 4});
        queue.offer(new int[]{2, 8, 1});
        queue.offer(new int[]{1, 6, 3});
        queue.offer(new int[]{5, 5, 10});

        System.out.println(Arrays.toString(queue.poll()));
        System.out.println(Arrays.toString(queue.peek()));
        queue.offer(new int[]{9, 0, 3});

        while (!queue.isEmpty()) {
            System.out.println(Arrays.toString(queue.poll()));
        }
    }
}
