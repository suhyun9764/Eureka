package com.springboot.springbootbasicjunit5.basic;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Assert_2 {

    @Test
    @Order(1)
    void testAssertThrows() {
        MyClass mc = new MyClass();
        String str = "hello";
//        String str = null;


        assertThrows(
                NullPointerException.class,
                () -> mc.getStringLength(str),
                "mc.getStringLength() 는 NullPointerException을 발생시켜야 한다.");


        /* 이렇게 작성하면 안되고 람다식으로 표현해줘야 한다.

        assertThrows(
                NullPointerException.class,
                mc.getStringLength(str),
                "mc.getStringLength() 는 NullPointerException을 발생시켜야 한다.");
*/
    }

    int m1() {
        return 1;
    }

    boolean m2() {
        return false;
    }

    String m3() {
        return "hello";
    }

    @Test
    @Order(2)
    void testAssertAll() {
        assertAll(
                "묶음 테스트",
                () -> assertEquals(4, m1()),
                () -> assertTrue(m2()),
                () -> assertNotNull(m3())
        );
    }

    // array, collection

    int[] expectedArray = {1, 2, 3};
    int[] actualArray = {1, 2, 4};

    @Test
    @Order(3)
    void testAssertArrayEquals() {
        assertArrayEquals(expectedArray, actualArray, "두 배열은 같아야 한다.");
    }

    //assertNotArrayEquals는 없다 !

    List<String> expectedList = Arrays.asList("aaa", "bbb", "ccc");
    List<String> actualList = Arrays.asList("aab", "bbb", "ccc");


    @Test
    @Order(4)
    void testAssertIterableEquals() {
        assertIterableEquals(expectedList, actualList, "두 컬렉션은 같아야 한다.");
    }

    // MyClass 의 equals() & hashcode 가 없으면 실패
    List<MyClass> expectedList2 = Arrays.asList(new MyClass(), new MyClass(), new MyClass());
    List<MyClass> actualList2 = Arrays.asList(new MyClass(), new MyClass(), new MyClass());

    @Test
    @Order(5)
    void testAssertIterableEquals2() {
        assertIterableEquals(expectedList2, expectedList2, "두 컬렉션은 같아야 한다.");
    }

    // equals ~~~ () 객체의 경우 필드 비교 일반적, 만약 주소 참조값을 비교한다면 ?

    @Test
    @Order(6)
    void testAssertSame() {
        String str1 = "JUnit";
        String str2 = str1;
        String str3 = "JUnit";
        assertSame(str1, str2, "두 변수는 같은 객체를 가리킨다.");
        assertSame(str1, str3, "두 변수는 같은 객체를 가리킨다.");
    }
    @Test
    @Order(7)
    void testAssertNotSame() {
        String str1 = "JUnit";
        String str2 = new String("JUnit");
        String str3 = "JUnit";
        assertNotSame(str1, str2, "두 변수는 다른 객체를 가르친다.");
        assertNotSame(str1, str3, "두 변수는 다른 객체를 가르친다.");
    }

    void myFunc() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    @Order(8)
    void testAssertTimeout() {
        assertTimeout(Duration.ofSeconds(1L),
                () -> myFunc(),
                "myFunc 는 0.5초 이내로 수행되어야 한다."
        );
    }
}
