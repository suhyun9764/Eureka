package ch13;

// generic을 가진 클래스
public class Applicant<T> {
    public T kind;

    public Applicant(T t) {
        this.kind = t;
    }
}