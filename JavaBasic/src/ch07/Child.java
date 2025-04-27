package ch07;

public class Child extends Parent{

    public Child() {
        super(1);
    }

    // 부모와 중복된 필드
    int n = 20;

    public void m(){
        System.out.println(n);
        System.out.println(this.n); // 현재 클래스에 n이 없어도 this.를 사용하면 부모의 값을 호출한다
        System.out.println(super.n);
    }
}
