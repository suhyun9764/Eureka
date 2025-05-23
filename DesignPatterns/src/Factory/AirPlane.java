package Factory;

public class AirPlane implements Transportation{
    @Override
    public void move() {
        System.out.println("비행기가 날아갑니다.");
        check();
    }

    private void check(){
        System.out.println("비행기가 잘 가고 있습니다");
    }
}
