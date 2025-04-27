package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_팀프로젝트{
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int n;
            int[] member;
            n = Integer.parseInt(br.readLine());
            member = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m=1;m<=n;m++){
                member[m] = Integer.parseInt(st.nextToken());
            }
            project(member);
        }
    }

    private static void project(int[] member) {
        int answer = 0 ;
        int[] team = new int[member.length];
        Arrays.fill(team,0);
        for (int i=1;i<=member.length-1;i++){
            if(team[i]==0) {
                Set<Integer> members = new HashSet<>();
                members.add(i);
                dfs(i,i,member,team, members);
            }
        }
        for(int i=1;i<member.length;i++){
            if(team[i]==-1)
                answer++;
        }
        System.out.println(answer);
    }

    private static void dfs(int current, int target, int[] member, int[] team, Set<Integer> members) {
        int want = member[current];
        if(members.contains(want)){
            if(want==target){
                for (Integer m : members) {
                    team[m] = 1;
                }
            }else{
                team[target]=-1;
            }
            return;
        }

        members.add(want);
        dfs(want,target,member,team,members);

    }
}
