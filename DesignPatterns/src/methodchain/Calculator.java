package methodchain;

public class Calculator {
    private int first;
    private int second;

    // pattern 적용 전
//    public void setFirst(int i) {
//        this.first = i;
//    }
//
//    public void setSecond(int i) {
//        this.second = i;
//    }
//
//    public void  add() {
//        System.out.println(this.first+this.second);
//    }
//
//    public void sub() {
//        System.out.println(this.first-this.second);
//    }

    // pattern 적용 후
    public Calculator setFirst(int i) {
        this.first = i;
        return this;
    }

    public Calculator setSecond(int i) {
        this.second = i;
        return this;
    }

    public Calculator  add() {
        System.out.println(this.first+this.second);
        return this;
    }

    public Calculator sub() {
        System.out.println(this.first-this.second);
        return this;
    }
}
