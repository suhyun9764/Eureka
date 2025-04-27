package ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Error vs Exception
//        m();

//        m2(); // Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "str" is null

        m3();
    }

    private static void m3() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("readme.md");
    }


    // Exception in thread "main" java.lang.StackOverflowError
    static void m(){
        m();
    }

    static void m2(){
        String str = null;
        System.out.println(str.length());
    }
}
