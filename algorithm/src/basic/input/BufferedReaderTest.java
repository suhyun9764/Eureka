package basic.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        // BufferedReader(InputStreamReader())
        // 처리코드는 Scanner에 비해 다소 복잡하지만, 매우 빠른 성능을 보장

//        // 1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // "1,2,3,4,5"
//
//            int[] input = new int[5];
//            StringTokenizer st = new StringTokenizer(str);
//            for(int i=0;i<input.length;i++){
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//        }

        // 1 A 3 B 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // "1,2,3,4,5"
//
//            char[] input = new char[5];
//            StringTokenizer st = new StringTokenizer(str);
//            for(int i=0;i<input.length;i++){
//                input[i] = st.nextToken().charAt(0);
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

//        // 1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str = br.readLine(); // "1,2,3,4,5"
//
//            char[] charArr = str.toCharArray();
//            System.out.println(Arrays.toString(charArr));
//
//        }

        // 5
        // 1 2 3 4 5
//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//            String str = br.readLine(); // "1,2,3,4,5"
//
//            int[] input = new int[N];
//            StringTokenizer st = new StringTokenizer(str);
//            for (int i = 0; i < input.length; i++) {
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

/*
5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
*/

//        {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int N = Integer.parseInt(br.readLine());
//
//            int[][] arr = new int[N][N];
//            for(int i=0;i<N;i++){
//                String str = br.readLine();
//                StringTokenizer st = new StringTokenizer(str);
//                for(int j=0;j<N;j++){
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            System.out.println(Arrays.toString(arr));
//        }

        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][M];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++){
                System.out.println(Arrays.toString(arr[i]));
            }
        }
    }


}
