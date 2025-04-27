package ch08;

public class Test {
    public static void main(String[] args) {
        // 타입의 다형성
        // 왼쪽 interface 타입, 오른쪽 구현 타입
        {
//        IFC ifc = new IFImpl();   // o
//        IFC ifc2 = new IFImpl();  // x
//        IFB ifb = new IFImpl();   // o
            IFA ifa = new IFImpl();
        }

        // 인터페이스 타입 선언 및 메서드 호출
        // 선언된 인터페이스에 정의된 메서드만 호출 가능
        {
            IFB ifb = new IFImpl();
            ifb.ma();
            ifb.mb();
//            ifb.mc(); // x
            IFA ifa = new IFImpl();
            ifa.ma();
//            ifa.mb();   // x
        }
    }
}
