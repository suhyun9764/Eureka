package week_1;

public class WrapperClass {
    public static void main(String[] args) {
        Integer wrapperMyAge1 = new Integer(28); // Boxing
        int unboxingMyAge = wrapperMyAge1.intValue();  // UnBoxing

        Integer wrapperMyAge2 = new Integer(28);

        System.out.println("myAge1과 myAge2는 같은 객체인가? : " + (wrapperMyAge1 == wrapperMyAge2));    // false
        System.out.println("myAge1과 myAge2는 같은 값을 가지나? : " + (wrapperMyAge1.equals(wrapperMyAge2)));   // true

        int primitiveMyAge = wrapperMyAge1; // AutoUnboxing;
        Integer wrapperMyAge3 = primitiveMyAge;  // AutoBoxing;
    }
}
