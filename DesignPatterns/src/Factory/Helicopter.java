package Factory;

public class Helicopter implements Transportation{
    @Override
    public void move() {
        System.out.println("헬리콥터가 날아갑니다");
    }
}
