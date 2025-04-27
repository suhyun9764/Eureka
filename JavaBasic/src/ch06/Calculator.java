package ch06;

public class Calculator {
    // static initializer
    static {
        System.out.println(1);
    }
    static double pi = 3.1415;
    int sum;
    static int plus(int a, int b){
//        sum += a+b; // static 메서드에서 non-static 필드에 접근 x
        return a+b;
    }

    static {
        System.out.println(2);
    }
}
