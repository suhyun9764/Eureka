package com.springboot.springbootbasicloggin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// com.mycom.myapp.repository의 모든 메서드가 호출될 때 기본 로그를 남기는
// repository 패키지의 메서드는 모두 login 한 상태에서만 호출 가능
@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LoggingAspect {
    // session
    private final HttpSession httpSession;
    @Pointcut(value = "execution(* com.springboot.springbootbasicloggin.repository.*.*(..))")
    private void logPointCut(){
    }

    // 로그인 한 사용자가 호출할 경우, 호출한 사용자의 이름과 시간을 출력한다
    @Before("logPointCut()")
    public void logRepositoryMethodCall(JoinPoint joinPoint){   // JoinPoint는 위 PointCut의  대상중 실제로 호출된 메서드의 진입점
        String username = (String) httpSession.getAttribute("username");
        if(username==null) return;

        String methodName = joinPoint.getSignature().getName(); // 메서드 이름
        log.info("user["+username+"]가 method : " + methodName+" 을 " + LocalDateTime.now() + "호출했습니다");
    }
}
