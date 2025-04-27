package basic.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

// 우선 순위 Queue
// 내부적으로 Heap 자료 구조
// 넣은 순서대로 나오는 것이 아니라, 생성하면서 함께 제공하는 또는 Queue에 담기는 클래스의 정렬조건
public class TestPQ {
    public static void main(String[] args) {
        {
            PriorityQueue<Integer> pqueue = new PriorityQueue<>();

            pqueue.offer(3);
            pqueue.offer(2);
            pqueue.offer(7);
            pqueue.offer(5);
            pqueue.offer(9);

            while (!pqueue.isEmpty())
                System.out.println(pqueue.poll());
        }

        {
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.c-o2.c;
                }
            });
            priorityQueue.offer(new Edge(2,5,4));
            priorityQueue.offer(new Edge(1,6,3));
            priorityQueue.offer(new Edge(7,5,8));
            priorityQueue.offer(new Edge(3,9,1));

            while (!priorityQueue.isEmpty()){
                System.out.println(priorityQueue.poll());
            }
        }
    }


    static class Edge {
        int v1, v2, c;

        Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", c=" + c +
                    '}';
        }
    }
}
