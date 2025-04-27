package com.springbackground.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// interface 앞에 @ 붙혀서 annotation 생성
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AboutMe {
    String love();
    String hate();
}
