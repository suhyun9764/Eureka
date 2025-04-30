package com.springboot.springbootbasicjunit5.basic;

import java.util.Objects;

public class MyClass {
    int n = 10;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return n == myClass.n;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(n);
    }

    public boolean getResult() {
        return true;
    }

    public String getString(){
        return null;
    }

    public String getString2() {
        return "hi";
    }

    public int getStringLength(String str){
        return str.length();
    }
}
