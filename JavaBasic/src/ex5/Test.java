package ex5;

import java.io.*;

public class Test {
    // 객체 직렬화
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyClass mc = new MyClass();
        mc.n = 10;
        mc.str = "hello";
        mc.ssn = "00000-11111";
        // 직렬화
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyClass.dat"));
//        oos.writeObject(mc);

//         역직렬화
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyClass.dat"));
        MyClass myClass = (MyClass) ois.readObject();
        System.out.println(myClass.n);
        System.out.println(myClass.str);
        System.out.println(myClass.ssn);

    }
}
