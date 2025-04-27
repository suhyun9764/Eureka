package ch06;

import ch06.a.A;

//Test 5와 A,B 각각 다른 패키지
public class Test5 {
    //private
    A a = new A();
//    int x1 = a.n; // not visible

    //public
    int x = a.n2;

    //default
//    int x = a.n3;   //not visible <= 다른 패키지

}
