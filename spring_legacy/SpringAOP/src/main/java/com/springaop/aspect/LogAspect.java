package com.springaop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // trace > debug > info > warn > error
    // PointCut ( Join Point (모든 메서드) 중 어떤 메서드에 끼여 들 것인가 표현 )
    // application.properties에서 설정 가능
    @Pointcut(value = "execution(* com.springaop.aspect.*(..))") // return package class name parameter
    private void logPointCut(){}   // 이름이 logPointCut() 인 PointCut 1개 생성

    @Before("logPointCut()")
    public void beforeLog(JoinPoint joinPoint){
//        System.out.println("[sout : before]");
        logger.info("[Logger : before]");
        logger.info(joinPoint.getSignature().getName());
    }

    @After("logPointCut()")
    public void afterLog(JoinPoint joinPoint){
        logger.debug("[Logger : after]");
    }
}
