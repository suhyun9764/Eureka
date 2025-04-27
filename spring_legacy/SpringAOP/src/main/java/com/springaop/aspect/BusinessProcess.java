package com.springaop.aspect;

import org.springframework.stereotype.Component;

@Component
public class BusinessProcess {
    public void bp(){
        System.out.println("bp : ");
    }

    public void no_bp(){
        System.out.println("no_bp : ");
    }

    public int int_bp(){
        System.out.println("int_bp : ");
        return 1;
    }

    public void String_bp(){
        System.out.println("String_ bp : ");
    }
}
