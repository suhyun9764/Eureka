package ch06;

public class Test {
    public static void main(String[] args) {
        Car car1 = new Car(1);
        Car car2 = new Car("소나타", 10);
        System.out.println(car1.name);
        System.out.println(car1.speed);
        System.out.println(car2.name);
        System.out.println(car2.speed);

        car1.drive();
        car2.drive();
        car1.getDriveInfo("고속도로");
    }

}
