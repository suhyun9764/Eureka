package ch16.ex3;


public class Person {
    // 전달되는 일을 수행
    public void action(Calculable calculable){
        int result = calculable.calculate(6,3);
        System.out.println(result);
    }
}
