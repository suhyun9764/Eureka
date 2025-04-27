package com.springbackground.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Spring Framework이 User를 들여다 본다
public class Test {
    public static void main(String[] args) throws Exception{
        Class<?> userClass = Class.forName("com.springbackground.reflection.User");

        // class 이름
        String name = userClass.getName();

        Field[] fields = userClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println();
        }

        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println();
        }
        System.out.println(name);

        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(constructor.getParameterCount());
            System.out.println();
        }
    }
}
