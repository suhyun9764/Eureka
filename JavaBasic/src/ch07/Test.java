package ch07;

public class Test {
    public static void main(String[] args) {
        // 상속
        {
//            Parent p = new Parent();
//            Child c = new Child();
        }

        // Parent 생성자 추가
        {
            Child child = new Child();
            child.m();
        }
    }
}


// 컴파일러가 자동으로 하는 일
// 1. 생성자가 없으면 기본 생성자를 추가
// 2. java.lang 자동으로 import
// 3. 생성자에 super()가 없으면 자동으로 추가
// 4. 아무것도 상속받지 않는 클래스는 자동으로 extends object를 추가한다