package com.springboot.springbootbasicjunit5.wepapp.di;

import com.springboot.springbootbasicjunit5.user.controller.UserController;
import com.springboot.springbootbasicjunit5.user.entity.User;
import com.springboot.springbootbasicjunit5.user.repository.UserRepository;
import com.springboot.springbootbasicjunit5.user.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// Spring Context 전체를 이용한 Test => @SpringBootTest

// Spring Web을 이요한 Test => @WebMvcTest
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class Test_DI_1 {
    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    @Order(0)
    void testDi(){
        assertNotNull(userController);
        assertNotNull(userService);
        assertNotNull(userRepository);
    }

    @Test
    @Order(1)
    void testDI_ALL(){
        assertAll(
                ()->{
                    assertNotNull(userController);
                    assertNotNull(userService);
                    assertNotNull(userRepository);
                }
        );
    }

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletRequest request;

    @Test
    @Order(2)
    void testDi_session_request(){
        log.debug("testDi_session_request() 시작");
        assertNotNull(session);
        assertNotNull(request);
        log.debug("testDi_session_request() 종료");
    }

    //jpa 영역
    @Autowired
    EntityManager entityManager;

    @Test
    @Order(4)
    void testDi_entity_manager(){
        log.debug("testDi_entity_manager() 시작");
        assertNotNull(entityManager);
        User user = entityManager.find(User.class,1);
        assertNotNull(user);
        log.debug("testDi_entity_manager() 종료");
    }
}
