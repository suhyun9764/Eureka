package com.springboot.springbootbasicjunit5.basic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// assertOOO 메서드를 통해서 판단(같다, 다르다, null이다, null이 아니다...)
// assertOOO 매소드의 테스트가 실패하면 세 번째 message가 Failure Trace 맨 앞에 표시
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Assert_1 {
    @Test
    @Order(1)
    void testAssertEquals(){
//        assertEquals(1,2,"1==1");
        int legacyNum = LegacySystem.getNum();
        int testNumb = TestSystem.getNum();
        assertEquals(legacyNum,testNumb, "LegacySystem과 TestSystem 비교");
     }

    @Test
    @Order(2)
    void testAssertNotEquals(){
//        assertEquals(1,2,"1==1");
        int legacyNum = 2;
        int testNumb = 3;
        assertNotEquals(legacyNum,testNumb, "LegacySystem과 TestSystem 비교");
    }

    @Test
    @Order(3)
    void testAssertEqualsObject(){
        //MyClass에 equals(), hashcode() 선언 전은 실패, 후에는 성공
        MyClass mc = new MyClass();
        MyClass mc2 = new MyClass();
        assertEquals(mc,mc2, "mc와 mc2 equal 비교");
    }

    @Test
    @Order(4)
    void testAssertTrue(){
        MyClass mc = new MyClass();
//        assertEquals(mc.getResult(),true);
        assertTrue(mc.getResult(),"mc.getResult()의 결과가 ture이어야 한다");
    }


    @Test
    @Order(5)
    void testAssertFalse(){
        MyClass mc = new MyClass();
//        assertEquals(mc.getResult(),true);
        assertTrue(mc.getResult(), "mc.getResult()의 결과가 ture이어야 한다");
    }

    @Test
    @Order(6)
    void testAssertNull(){
        MyClass mc = new MyClass();
        assertNull(mc.getString(),"mc.getString()의 결과가 null이어야 한다");
    }

    @Test
    @Order(7)
    void testAssertNotNull(){
        MyClass mc = new MyClass();
        assertNotNull(mc.getString2(),"mc.getString()의 결과가 null이어야 한다");
    }
}
