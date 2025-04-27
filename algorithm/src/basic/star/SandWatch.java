package basic.star;

public class SandWatch {
    public static void main(String[] args) {
        int turnCnt = 7 / 2;
        int spaceCnt = 0;
        boolean spaceIncrease = true;

        for (int i = 0; i < 7; i++) {
//            int currentStar = 1+Math.abs(i-3)*2;    // 총 별 갯수
//            int currentBlank = 7-currentStar;
//            for(int j=0;j<currentBlank/2;j++){
//                System.out.print(" ");
//            }
//            for(int k=0;k<currentStar;k++){
//                System.out.print("*");
//            }
//            for(int j=0;j<currentBlank/2;j++){
//                System.out.print(" ");
//            }
//            System.out.println();


            // #1
//            for (int j = 0; j < 7; j++) {
//                if (j < spaceCnt) {
//                    System.out.print(" ");
//                } else if (j < 7 - spaceCnt) {
//                    System.out.print("*");
//                }
//            }

            //#2 뒤 쪽 공백 자리는 따질 필요 x
            for (int j = 0; j < 7-spaceCnt; j++) {
                if (j < spaceCnt) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();

            // 공백 증가 여부
            if (spaceIncrease) spaceCnt++;
            else
                spaceCnt--;

            // 다음 행에서 계속 증가 또는 감소 판단
            if (spaceCnt == turnCnt)
                spaceIncrease = false;
        }
    }
}
