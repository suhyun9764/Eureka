package ch16.ex2;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();   // 일하는 사람을 만들고
        // 일의 종류마다 구현 클래스 및 객체를 만들지 않고
        // 일 각각을 람다식으로 표현 전달
        person.action((name,job)->{
            System.out.println(name+"이"+job+"을 수행합니다.");
        });// 그 사람에게 할 일을 부여

        person.action((name,job)->{
            System.out.println(name+"이"+job+"을 수행하지 않습니다.");
        });

        person.action2(content-> System.out.println(content+"캍퇴!"));
    }
}
