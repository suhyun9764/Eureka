package ch07;

public class Example {

    public static void main(String[] args) {
        // 1. 부모의 기본형
        Car car = new Car();
        car.move(); // 차가 움직입니다

        // 2. 자식으로 생성했지만 부모로 업캐스팅
        Car car1 = new ElectricCar();
        car1.move(); // 전기차가 움직입니다

        // 3. 다운 캐스팅(성공)
        ElectricCar electricCar = (ElectricCar) car1;
        electricCar.move();    // 전기차가 움직입니다

        // 4. 다운 캐스팅(실퍠)
//        ElectricCar electricCar1 = (ElectricCar) car;
//        electricCar1.move();    // ClassCastException 발생

        // 5. 안전한 다운캐스팅

        if (car1 instanceof ElectricCar) {
            ElectricCar sampleCar = (ElectricCar) car1;
            sampleCar.move();    // 전기차가 움직입니다
        }else{
            System.out.println("형 변환이 불가능합니다");
        }

    }

    static class Car {
        public void move() {
            System.out.println("차가 움직입니다");
        }
    }

    static class ElectricCar extends Car {
        public void move() {
            System.out.println("전기차가 움직입니다");
        }

        void charge() {
            System.out.println("전기를 충전합니다");
        }
    }
}
