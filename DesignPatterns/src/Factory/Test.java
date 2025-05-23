package Factory;

// A a = new A();
// T a  = new B();
// X a = Factory.create("...")

public class Test {
    public static void main(String[] args) {
        // Factory가 없을 경우
//        Transportation t1 = new Car();
//        Transportation t2 = new AirPlane();
//        Transportation t3 = new Helicopter();

        Transportation t1 = TransportationFactory.getTransportation("A");
        Transportation t2 = TransportationFactory.getTransportation("C");
        Transportation t3 = TransportationFactory.getTransportation("H");

        t1.move();
        t2.move();
        t3.move();

        // 만약 car 객체 대신 새로운 SportsCar 객체가 필요하다
    }
}
