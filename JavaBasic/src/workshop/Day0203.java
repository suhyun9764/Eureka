package workshop;

import java.util.Objects;

public class Day0203 {
    public static void main(String[] args) {
        Person person = new Person(28, "신수현");
        Person person2 = new Person(28, "신수현");

        System.out.println(person.equals(person2)); // True
    }

    static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // hashCode 재정의
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        // equals 재정의
        @Override
        public boolean equals(Object o) {
            if (this == o)  // 같은 참조 값을 가지는지 확인(== 같은 객체 인지)
                return true;
            if (!(o instanceof Person)) {   // 타입이 다르다면 false
                return false;
            }


            Person person = (Person) o;

            // hashCode 재정의 했을 때
            return person.hashCode()==hashCode();   // 참조 값이 다르지만 데이터가 같을 떄

//            hashCode() 재정의 하지 않았을 때
//            return this.age == person.age &&  //
//                    this.name.equals(person.name);

        }
    }
}
