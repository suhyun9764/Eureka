package com.springboot.springbootbasicjunit5.wepapp.di;

import com.springboot.springbootbasicjunit5.auth.service.LoginService;
import com.springboot.springbootbasicjunit5.user.controller.UserController;
import com.springboot.springbootbasicjunit5.user.repository.UserRepository;
import com.springboot.springbootbasicjunit5.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// Spring Context 전체를 이용한 Test => @SpringBootTest

// Spring Web을 이요한 Test => @WebMvcTest
@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class Test_DI_2 {
//    @Autowired
//    MockMvc mockMvc;

    // since 3.4.x @MockBean -> @MockitoBean
    @MockitoBean
    UserController userController;

    @MockitoBean
    UserService userService;

    @MockitoBean
    UserRepository userRepository;

    @MockitoBean
    LoginService loginService;

    @Test
    @Order(0)
    void testDi(){
        assertNotNull(userController);
        assertNotNull(userService);
        assertNotNull(userRepository);
    }

//    @Test
//    @Order(1)
//    void testDI_ALL(){
//        assertAll(
//                ()->{
//                    assertNotNull(userController);
//                    assertNotNull(userService);
//                    assertNotNull(userRepository);
//                }
//        );
//    }

    @MockitoBean
    HttpSession session;

    @MockitoBean
    HttpServletRequest request;

    @Test
    @Order(2)
    void testDi_session_request(){
        log.debug("testDi_session_request() 시작");
        assertNotNull(session);
        assertNotNull(request);
        log.debug("testDi_session_request() 종료");
    }
//
//    //jpa 영역
//    @MockitoBean
//    EntityManager entityManager;

//    @Test
//    @Order(4)
//    void testDi_entity_manager(){
//        log.debug("testDi_entity_manager() 시작");
//        assertNotNull(entityManager);
//        User user = entityManager.find(User.class,1);
//        assertNotNull(user);
//        log.debug("testDi_entity_manager() 종료");
//    }
}
