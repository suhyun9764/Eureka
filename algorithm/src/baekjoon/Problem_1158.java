package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1158 {
//    static int N;
//    static int K;
//    static int[] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        init(st);   // 입력 받고 초기 설정
//        getAnswer();
//    }
//
//    private static void init(StringTokenizer st) {
//        // 1. N,K 입력받기
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//
//        // 2. 1~N 까지의 배열 저장하기
//        arr = new int[N];
//
//        for(int i=0;i<N;i++){
//            arr[i] = i+1;
//        }
//    }
//
//    private static void getAnswer() {
//        StringBuilder answer = new StringBuilder();
//        answer.append("<");
//
//        // 3. remain이 0이 될 때까지 k번째 사람 제거 후 출력
//        int remain = N; // 남은 사람
//        int cnt = 0;    // 현재 가리키는 인덱스(사람 자리)
//        int kCnt = 0;   // n번째 사람
//        while (remain>0){
//            // 현재 순서의 사람 인덱스 구하기
//            int currentPerson = cnt++%N;
//            // 살아있는 사람인지 확인
//            if(isABoolean(currentPerson))
//                continue;
//            kCnt++;
//            // 만약 k번째 사람이라면 제거
//            if(kCnt%K==0) {
//                answer.append(arr[currentPerson]);
//                arr[currentPerson] = 0;
//                remain--;   // 남은 사람 감소
//                if(remain==0){
//                    answer.append(">");
//                }else{
//                    answer.append(", ");
//                }
//            }
//        }
//        System.out.println(answer);
//    }
//
//    private static boolean isABoolean(int currentPerson) {
//        return arr[currentPerson] == 0;
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        List<Integer> result = new ArrayList<>();

        while (!list.isEmpty()) {
            for(int i = 0; i < M - 1; i++) {
                if(!it.hasNext()) { // 마지막 원소 도달
                    it = list.iterator(); // 순회 구조를 위해 다시 초기화
                }
                it.next();
            }

            if (!it.hasNext()) {
                it = list.iterator();
            }

            int removed = it.next(); // M 번째 사람
            it.remove();
            result.add(removed);
        }

        System.out.println(result.toString().replace("[", "<").replace("]", ">"));
    }
}
