package programmers;

import java.util.*;

public class Problem_이중우선순위큐 {
    public static void main(String[] args) {
//        String[] operations = {
//                "I -45",
//                "I 653",
//                "D 1",
//                "I -642",
//                "I 45",
//                "I 97",
//                "D 1",
//                "D -1",
//                "I 333"
//        };

        String[] operations = {
                "I 16",
                "I -5643",
                "D -1",
                "D 1",
                "D 1",
                "I 123",
                "D -1"
        };

        Solution solution = new Solution();
        int[] answer = solution.solution(operations);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < operations.length; i++) {
                String operation = operations[i];
                String order = operation.split(" ")[0];
                int value = Integer.parseInt(operation.split(" ")[1]);

                if (order.equals("I")) {
                    if (map.containsKey(value)) {
                        map.put(value, map.get(value) + 1);
                    } else {
                        map.put(value, 1);
                    }
                    minQueue.add(value);
                    maxQueue.add(value);
                } else if (order.equals("D")) {
                    if (map.isEmpty()) continue;
                    if (value == -1) {
                        int pollValue = minQueue.poll();
                        if (map.containsKey(pollValue)) {
                            if (map.get(pollValue) == 1)
                                map.remove(pollValue);
                            else
                                map.put(pollValue, map.get(pollValue) - 1);
                            while (!map.containsKey(maxQueue.peek()) && !maxQueue.isEmpty())
                                maxQueue.poll();
                        }

                    } else {
                        int pollValue = maxQueue.poll();
                        if (map.containsKey(pollValue)) {
                            if (map.get(pollValue) == 1)
                                map.remove(pollValue);
                            else
                                map.put(pollValue, map.get(pollValue) - 1);

                            while (!map.containsKey(minQueue.peek()) && !minQueue.isEmpty())
                                minQueue.poll();
                        }
                    }
                }
            }


            int max = 0;
            int min = 0;
            while (!map.containsKey(minQueue.peek()) && !minQueue.isEmpty())
                minQueue.poll();
            while (!map.containsKey(maxQueue.peek()) && !maxQueue.isEmpty())
                maxQueue.poll();
            if (!maxQueue.isEmpty()) {
                max = maxQueue.poll();

            }

            if (!minQueue.isEmpty()) {
                min = minQueue.poll();
            }

            return new int[]{max, min};
        }
    }
}
