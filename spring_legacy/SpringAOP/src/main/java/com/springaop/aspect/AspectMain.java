package com.springaop.aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/aspect.xml");
        BusinessProcess businessProcess = (BusinessProcess) context.getBean("businessProcess");
        businessProcess.bp();
        System.out.println();

        businessProcess.no_bp();
        System.out.println();

        businessProcess.int_bp();
        System.out.println();

        businessProcess.String_bp();
        System.out.println();


    }

}
