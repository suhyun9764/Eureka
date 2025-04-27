package basic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    // 완전이진트리(왼쪽 노드부터 채워져야함) vs 포화 이진트리(삼각형 꽉차게)
    /*
                    1                               1
               2        3                       2       3
            4                                4     5  6    7
     */
    // 이진 트리를 배열로
    static int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        bfs(1);
        System.out.println(sb);

        sb.setLength(0);    // 초기화

        dfs(1);
        System.out.println(sb);
    }

    private static void bfs(int idx) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(idx);

        while (!queue.isEmpty()) {
            int currentIdx = queue.poll();
            sb.append(tree[currentIdx]).append(" ");
            // 꺼낸 노드의 자식 노드 방문
            int lcIdx = currentIdx * 2;
            int rcIdx = currentIdx * 2 + 1;

            // range check
            if (lcIdx < tree.length) queue.offer(lcIdx);
            if (rcIdx < tree.length) queue.offer(rcIdx);
        }
    }

    private static void dfs(int idx) {
        if(idx >= tree.length) return;

        sb.append(tree[idx]).append(" ");

        // 현재 노드의 자식 노드 방문
        // 왼쪽
        dfs(idx*2);
        // 오른쪽
        dfs(idx*2+1);
    }

}
