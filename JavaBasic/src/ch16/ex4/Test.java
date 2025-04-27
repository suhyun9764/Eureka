package ch16.ex4;

public class Test {

    // Method Reference <- Lamda 간단 표현식
    public static void main(String[] args) {
        Person person = new Person();

        person.action((x,y)->{
            return Computer.staticMethod(x,y);
        });

        person.action((x,y)->Computer.staticMethod(x,y));

        // Method Reference
        // 파라미터와 그 사용이 명확할 때
        person.action(Computer::staticMethod);

        // Computer 객체의 instanceMethod를 호출 1
        Computer computer = new Computer();
        person.action((x,y)-> computer.instanceMethod(x,y));

        // Computer 객체의 instanceMethod를 호출 2
        person.action(computer::instanceMethod);
    }
}
