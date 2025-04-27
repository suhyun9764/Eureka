package com.springbackground.annotation;

import java.lang.annotation.Annotation;

public class Test {
    public static void main(String[] args) throws Exception {
        Class<?> myClass = Class.forName("com.springbackground.annotation.MyClass");
        Annotation[] annotations = myClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if(annotation instanceof AboutMe){
                AboutMe aboutMe = (AboutMe) annotation;
                System.out.println(aboutMe.love());
                System.out.println(aboutMe.hate());
            }
        }
    }
}
