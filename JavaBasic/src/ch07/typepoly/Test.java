package ch07.typepoly;

public class Test {

    public static void main(String[] args) {
        // 타입 다형성
        {
            A a = new A();  // 자신 - 자신
            B b = new B();  // 자신 - 자신
            A ab = new B(); // 부모 - 자식
            //    B ba = new A(); // 자식 - 부모
        }
        {
            A a = new A();
            B b = new B();

            m1(a);
            m1(b);
//            m2(a);  // x
            m2(b);
        }
    }

    // 타입 다형성 : parameter
    static void m1(A a) {
    }

    static void m2(B b) {
    }

    // 타입 다형성 : return type
    static A m3() {return new A();}
    static B m4() {return new B();}
    static A m5() {return new B();}
//    static B m6() {return new A();}

    //자식 타입 <= 부모 객체 일 경우 오류 발생
}
