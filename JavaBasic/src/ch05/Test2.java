package ch05;

public class Test2 {
    public static void main(String[] args) {
        //String 객체의 비교
//        {
//            String str1 = new String("Hello");
//            String str2 = new String("Hello");
//            String str3 = "Hello";
//            String str4 = "Hello";
//
//            // ==
//            System.out.println(str1 == str2);
//            System.out.println(str3 == str4);
//            System.out.println(str1 == str4);
//
//            // equals()
//            System.out.println(str1.equals(str2));
//            System.out.println(str3.equals(str4));
//            System.out.println(str1.equals(str4));
//
//
//            // MyClass 객체의 equals() 비교
//            MyClass mc1 = new MyClass();
//            MyClass mc2 = new MyClass();
//            mc1.name = "Hello";
//            mc2.name = "Hello";
//
//            System.out.println(mc1);
//            System.out.println(mc2);
//            System.out.println(mc1.equals(mc2));    // False <= 같은 참조 타입의 객체가 무조건 equals() 로 내용비교가 true가 되는 건 아니다.
//        }

        // String의 다양한 메서드
        {
            String str = "Hello";

            // length()
            System.out.println(str.length());

            // charAt()
            System.out.println(str.charAt(0));
//            System.out.println(str.charAt(5)); // StringIOBE 발생

            //replace()
            System.out.println(str.replace("He","aa"));
            System.out.println(str);

            //indexOf()
            System.out.println(str.indexOf("l"));

            System.out.println(str.substring(0,2));
            System.out.println(str.substring(0,str.indexOf("l"))+"X"+str.substring(str.indexOf("l")+1, str.length()));
        }
    }
}
