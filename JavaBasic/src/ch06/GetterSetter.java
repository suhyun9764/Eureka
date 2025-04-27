package ch06;

public class GetterSetter {
    // 필드를 외부에서 직접 read/update .. 하지 못하도록 하고
    // 메서드를 통새 ㅓ가능하게 구조를 만든다.

    private int n = 10;

    void m(){
        System.out.println("GetterSetter n : "+n);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
