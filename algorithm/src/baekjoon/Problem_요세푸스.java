package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_요세푸스 {
    static int N;
    static int K;
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        setting();
        getAnswer();
        System.out.println(answer.toString());
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        answer.append("<");
    }

    private static void getAnswer() {
        int cnt = 0;
        while (queue.size() > 1) {
            int currentPerson = queue.poll();
            cnt++;
            if (cnt == K) {
                answer.append(currentPerson);
                answer.append(", ");
                cnt = 0;
                continue;
            }
            queue.offer(currentPerson);
        }

        answer.append(queue.poll() + ">");
    }
}
