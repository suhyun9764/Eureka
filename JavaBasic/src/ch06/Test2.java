package ch06;

public class Test2 {
    static{
        System.out.println("X");
    }
    public static void main(String[] args) {

        // static 필드
        System.out.println(Calculator.pi);

        // static 메서드
        System.out.println(Calculator.plus(10,20));

        // 객체로부터 접근 가능하나 올바르지 않다.
        Calculator calculator = new Calculator();
        System.out.println(calculator.pi);

        // Non-static method call
//        hello();    // 호출 불가
        hello2();
    }

    static{
        System.out.println("Y");
    }
    public void hello(){}
    public static void hello2(){}
}
