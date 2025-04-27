package ch06.b;

import ch06.a.A;

// 상속 관계에서 protected에 접근 가능하다는 같은 객체내에서만 허용
public class B extends A {
    A aa = new A();
    public void m() {
//        A a = new A();
//        int x = a.n4; // 접근이 되지 않음
        int n5 = super.n4;
    }
}
