//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//// 반복문
//public class Problem_Z_2 {
//    static int N, r, c, ans;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//
//        // 풀이
//        N = (int) Math.pow(2, N);    // 2의 제곱수이므로 계속 반으로 나눌 수 있다.
//
//        // 원점 초기화
//        int y = 0;
//        int x = 0;
//
//        while (true) {
//            if(N==1) break;
//
//            N /= 2;
//            if(r<y+N&&c<x+N){   // 상좌
//                ;
//            }else if(r<y+N && c>=x+N ) {    // 상우
//                ans += N*N*1;
//                x+=N;
//            }else if(r>=y+N && c<x+N) {  //하좌
//                ans += N*N*2;
//                y += N;
//            }else{
//                ans+=N*N*3;
//                y+=N;
//                x+=N;
//            }
//        }
//
//        System.out.println(ans);
//    }
//}
