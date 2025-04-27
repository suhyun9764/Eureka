package ch11;

import java.io.FileNotFoundException;

public class Test2 {
    public static void main(String[] args) {
        // throws RuntimeException 계열과 Checked Exception 게열
//        {
//            m1();
//            m2();
//            m3();   // Unchecked Exception
//        }
        // 복수개의 예외
        {
            try{
                m1();
                m2();
            }catch (ClassNotFoundException | FileNotFoundException e){
                // 처리 코드
            }
        }
    }

    static void m1() throws ClassNotFoundException{

    }

    static void m2()throws FileNotFoundException {

    }

    static void m3() throws NullPointerException{

    }
}
