package ch16.ex3;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();

        // 덧셈
        person.action((x,y)->{
            return x+y;
        });

        // 뺄셈
        // return 문을 생략( 처리 결과가 자동으로 리턴)
        person.action((x,y)->x-y);

        // 곱셈
        person.action((x,y)->x*y);

        // 나눗셈 ( 메서드 사용 )
        person.action((x,y)->div(x,y));
    }

    public static int div(int x, int y){
        return x / y;
    }
}
