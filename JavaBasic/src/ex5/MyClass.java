package ex5;

import java.io.Serializable;

public class MyClass implements Serializable {
    int n;
    String str;

    // transient
    transient String ssn;
}
