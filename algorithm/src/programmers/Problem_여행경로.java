package programmers;

import java.util.*;

public class Problem_여행경로 {
    public static void main(String[] args) {
//        String[][] tickets = {
//                {"ICN", "JFK"},
//                {"HND", "IAD"},
//                {"JFK", "HND"}
//        };

        String[][] tickets = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

        Solution solution = new Solution();
        String[] answer = solution.solution(tickets);
        System.out.println(Arrays.toString(answer));
    }

    static class Solution {
        List<String[]> answers = new ArrayList<>();
        Set<String> countries = new HashSet<>();

        public String[] solution(String[][] tickets) {

            for (String[] ticket : tickets) {
                for (String country : ticket) {
                    countries.add(country);
                }
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!tickets[i][0].equals("ICN")) continue; // 출발지가 ICN이 아니면 스킵
                boolean[] visit = new boolean[tickets.length];
                visit[i] = true;
                List<Integer> order = new ArrayList<>();
                order.add(i);
                dfs(i, visit, tickets, order);
            }

            answers.sort((a,b)->{
                for(int i=0;i<a.length;i++){
                    int result =a[i].compareTo(b[i]);
                    if(result!=0) return result;
                }

                return 0;
            });
            return answers.get(0);
        }

        private void dfs(int current, boolean[] visit, String[][] tickets, List<Integer> order) {
            if (order.size() == tickets.length) {
                List<String> list = new ArrayList<>();
                for (int i=0;i<tickets.length;i++) {
                    Integer poll = order.get(i);
                    String departure = tickets[poll][0];
                    String arrival = tickets[poll][1];
                    if(i==0){
                        list.add(departure);
                    }
                    list.add(arrival);
                }

                String[] answer = new String[tickets.length+1];
                int cnt = 0;
                for (String country : list) {
                    answer[cnt++] = country;
                }
                answers.add(answer);

                return;
            }


            for (int i = 0; i < tickets.length; i++) {
                if (visit[i] || !tickets[i][0].equals(tickets[current][1])) continue;
                visit[i] = true;
                order.add(i);
                dfs(i, visit, tickets, order);
                order.remove(order.size()-1);
            }

        }
    }
}
