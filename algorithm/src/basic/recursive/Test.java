package basic.recursive;

public class Test {
    public static void main(String[] args) {
//        m1();
//        m1_param(0);
        m4(5);
    }

    static int m1_i=0;
    static void m1(){
        // local 변수 <- 재귀 호출마다 스택에 새로 만들어지고 초기화된다
//        int i = 0;
//        System.out.println("m1() "+i++);
//        m1();

        // static 변수
        System.out.println("m1() "+m1_i++);
        m1();
    }

    static void m1_param(int i){
        // 파라미터 변수
        System.out.println("m1_parama() "+i++);
        m1_param(i);
    }

//    static int m2_cnt = 5;
//    static void m2(){
//        System.out.println("앞 m2() " + m2_cnt);
//        // 기저 조건
//        if(m2_cnt > 0){
//            m2_cnt--;
//            m2();
//        }
//
//        System.out.println("뒤 m2() "+m2_cnt);
//    }

//    static int m3_cnt = 5;
//    static void m3(){
//        // 기저 조건
//        if(m3_cnt == 0) return;
//        System.out.println("앞 m3() " + m3_cnt);
//        m3_cnt--;
//        m3();
//        m3_cnt++;   // 이 코드가 없으면 static 변수 m3_cnt가 0으로 감소한 후 계속 0 유지, 원복 필요
//
//        System.out.println("뒤 m3() "+m3_cnt);
//    }


    static void m4(int m4_cnt){
        // 기저 조건
        if(m4_cnt == 0) return;
        System.out.println("앞 m3() " + m4_cnt);
//        m4_cnt--;
//        m4(m4_cnt);
//        m4_cnt++;   // 이 코드가 없으면 static 변수 m3_cnt가 0으로 감소한 후 계속 0 유지, 원복 필요

//        m4(m4_cnt-1);   // 호출 시 전달받은 m4_cnt는 변화x
        m4(m4_cnt--);

        System.out.println("뒤 m3() "+m4_cnt);
    }
}
