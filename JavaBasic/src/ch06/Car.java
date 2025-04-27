package ch06;

public class Car {

    // 4. 필드 추가
    String name;
    int speed;


    // 1. 생성자 없는 경우
    // 컴파일러가 기본생성자를 추가

    // 2. 생성자 1개 추가
    // 컴파일러가 기본생성자를 추가 x
//    public Car(int speed) {
//        this.speed = speed;
//    }


    // this. : 내가 가지고 있는 변수 호
    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    // 5. this() 활용 : 내가 가지고 있는 생성자 호출
    public Car(int speed){
        // name에 기본값 지정하고 Car(name,speed);
        this("아반떼",speed);
    }

    // 6. 메서드 추가
    public void drive(){
        System.out.println(this.name+"가 " + this.speed+"로 달린다.");
    }

    public String getDriveInfo(){
        return "this.name+\"가 \" + this.speed+\"로 달린다.\"";
    }

    public String getDriveInfo(String road){
        return road+"도로를"+this.name+"가 "+this.speed+"로 달린다.";
    }


}
