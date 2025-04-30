package com.springboot.springbootbasicjunit5.basic;

import org.junit.jupiter.api.*;

// 테스트 하려는 내용을 메서드로 만들고 메서드에 @Test 추가
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Basic {

    @Test
    @Order(5)
    void test1() {
        System.out.println("test1");
    }

    @Test
    @Order(3)
    @DisplayName("테스트 2 메소드를 테스트 합니다")
    void test2() {
        System.out.println("test2");
    }

    @Test
    @Order(1)
    void test3() {
        System.out.println("test3");
    }

    @Test
    @Order(4)
    @DisplayName("RuntimeException 예외 발생 . ")
    void test4() {
        System.out.println("test4()");
        String str = null;
        str.length();
    }



    // @beforeAll, @afterAll 은 static
    // 테스트 전 static 으로 호출 되고, Test_basic 객체 생성 후 호출 되는 UI 에는 보이지 않는다.
    @BeforeAll
    @DisplayName("전체 테스트 메서드 수행 전 한번 실행")
    static void beforeAll() {
        System.out.println("beforeAll()");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll()");
    }

    @BeforeEach
    @DisplayName("개별 테스트 메서드 수행 전 한번 실행")
    void beforeEach() {
        System.out.println("beforeEach()");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach()");
    }
}
