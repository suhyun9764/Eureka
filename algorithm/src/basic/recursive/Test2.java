package basic.recursive;

public class Test2 {
    // 팩토리얼 계산을 재귀호출을 이용해서 처리, 결과값 처리 다양하게
    public static void main(String[] args) {
//    factorial(5);
        int result = factorial2(5);
        System.out.println(result);
        factorial3(5, 1);
    }


    // #1. 결과 값을 static 변수
//    static int result = 1;
//    static void factorial(int n){
//        if(n==0) {
//            System.out.println(result); // 원하는 결과가 완성된 시점
//            return;
//        }
//        result*=n;
//        factorial(n-1);
//    }

    // #2. 결과값을 재귀호출의 return 값으로
    static int factorial2(int n) {
        // 기저조건
        if (n == 1) {
            return 1;
        }

        // n == 3
        return n * factorial2(n - 1);
    }

    // 3. 결과값을 재귀호출의 parameter 값으로
    static void factorial3(int n, int result) {
        if (n == 1) {
            System.out.println(result);
            return;
        }

        factorial3(n-1,result*n);

    }
}
