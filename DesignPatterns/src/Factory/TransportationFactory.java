package Factory;

public class TransportationFactory {
    public static Transportation getTransportation(String clsf) {
        Transportation t = null;
        switch (clsf) {
            case "A":
                t = new AirPlane();
                break;

            case "C":
//                t = new Car();
                t= new SportsCar();
                break;


            case "H":
                t = new Helicopter();
                break;
        }

        return t;
    }
}
