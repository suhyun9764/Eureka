package basic.input;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        // scanner
        // 편리하나 상대적(java.io)으로 무겁다
        // 매우 간단한 입력 처리에만 사용

        // 17 2 3 4 5
//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input = new char[5];
//            for(int i=0;i<input.length;i++){
//                input[i] = sc.next().charAt(0);
//            }
//
//            System.out.println(Arrays.toString(input));
//        }

//        // abcde <= 연속된 문자
//        {
//            Scanner sc = new Scanner(System.in);
//            char[] input;
//
//            input = sc.nextLine().toCharArray();
//
//
//            System.out.println(Arrays.toString(input));
//        }

        // 5
        // 1 2 3 4 5
//        {
//            Scanner sc = new Scanner(System.in);
//            int N = sc.nextInt();
//            int[] input = new int[N];
//
//            for(int i=0;i<5;i++){
//                input[i] = sc.nextInt();
//            }
//
//            System.out.println(N);
//            System.out.println(Arrays.toString(input));
//        }

        /*

         */
        {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextInt();
            char[] input = sc.nextLine().toCharArray();

            System.out.println(N);
            System.out.println(Arrays.toString(input));
        }
    }
}
