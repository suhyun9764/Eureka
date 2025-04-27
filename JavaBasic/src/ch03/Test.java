package ch03;

public class Test {

    public static void main(String[] args) {
//        {
//            int x = 10;
//            int y = 10;
//
//            x++;
//            ++x;
//
//            System.out.println(x);
//            System.out.println(++x);    // println()에 값이 전달되기 전에 x가 1증가한다
//            System.out.println(x++);    // println()에 값이 전달되고 난 후 x가 1증가한다
//            System.out.println(x);
//
//            y--;
//            --y;
//
//            System.out.println(y);
//            System.out.println(--y);
//            System.out.println(y--);
//            System.out.println(y);
//        }


        // 논리 연산자
//        {
//            int x = 10;
//            int y = 10;
//
//            if( ++x == 10 && y++==10){
//                System.out.println("A");
//            }else{
//                System.out.println("B");
//            }
//        }

//        // 논리 연산자
//        {
//            int x = 10;
//            int y = 10;
//
//            if( ++x == 11 && y++==10){
//                System.out.println("A");
//            }else{
//                System.out.println("B");
//            }
//
//            // x, y 모두 11
//            System.out.println(x);
//            System.out.println(y);
//
//            if( ++x == 12 && y++==11){
//                System.out.println("C");
//            }else{
//                System.out.println("D");
//            }
//
//            // x, y 모두 12
//            System.out.println(x);
//            System.out.println(y);
//
//            //&& -> ||
//            //||-> | 로 변경하면? 이미 전체 판명이 나더라도 나머지 판명을 이어간다. 결과적으로 y도 13이 된다.
//            if( ++x == 13| y++==12){
//                System.out.println("E");
//            }else{
//                System.out.println("F");
//            }
//
//            // x는 먼저 비교가 되서 true로 판명 (x 는 증가)
//            // y는 앞의 x 비교식에서 true로 이미 판명이 나서 전체 or 연산이 true 로 판명되어서 y+= == 12 비교식은 수행되지 않는다
//            // x는 13, y = 12
//            System.out.println(x);
//            System.out.println(y);
//
//            // OR || 로 진행하면서 &&,& 하는 예제 만들기
//            // 조별 활동에서 결과값을 예측하는 Quiz로 만들어 보기
//
//            int p = 10;
//            int q = 10;
//
//            if(++p ==10  & q++ == 10){
//                System.out.println("G");
//            }else{
//                System.out.println("H");
//            }
//
//            System.out.println(p);
//            System.out.println(q);
//        }


//        // 삼항 연산자
//        {
//            int score = 75;
//            //....
//            // score > 90 일 때 'A'
//            // score <=90 일 때 'B'
//            // score <=80 일 때 'C'
//            char grade = score>90? 'A' : 'B';
//            System.out.println(grade);
//
//            //....
//            // score > 90 일 때 'A'
//            // score <=90 일 때 'B'
//            // score <=80 일 때 'C'
//            grade = score>90? 'A' : (( score>80 )? 'B' : 'C');
//            System.out.println(grade);
//        }

        // 나눗셈 연산
        {
            int a = 10;
            int b = a/3;
            System.out.println(b);
        }


    }



}
