package ch04;

public class Test4 {
    public static void main(String[] args) {
        //break
//        for (int i = 0; i < 10; i++) {
//
//            if(i==5) break; // 0~4 출력 후 break
//            System.out.println(i);
//            if (i == 5)
//                break;     // 0~5 출력 후 break
//        }

//        //continue
//        for (int i = 0; i < 10; i++) {
//
//            if(i==5) continue; // 5 제외한 모든 수 출력
//            System.out.println(i);
////            if (i == 5)
////                continue;     // 0~9 모두 출력
//        }

        // nested
        for (int i = 0; i < 10; i++) {

//            if( i==5) continue;
            for (int j = 0; j < 10; j++) {
                if (j == 5) continue;
                System.out.print(i + " " + j + "  ");
            }
            System.out.println();
        }
    }
}
