package basic.dp;

public class Apartment {
    public static void main(String[] args) {
        // 파란색 : 피보나치
        // 노란색 : 전단계의 수
        System.out.println(getApartmentColors(8));
    }

    public static long[] blue = new long[50];
    public static long[] yellow = new long[50];

    private static long getApartmentColors(int n) {
        long blue = getBlue(n);
        long yellow = getYellow(n);
        return blue + yellow;
    }

    private static long getBlue(int n) {
        if(n==1||n==2)
            return 1;

        blue[1] = 1;
        blue[2] = 1;

        for(int i=3;i<=n;i++){
            blue[i] = blue[i-1]+blue[i-2];
        }

        return blue[n];
    }


    private static long getYellow(int n) {
        if(n==1)
            return 1;
        yellow[1] = 1;

        for(int i=2;i<=n;i++){
            yellow[i] = yellow[i-1]+blue[i-1];
        }

        return yellow[n];
    }
}
