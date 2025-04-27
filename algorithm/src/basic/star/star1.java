package basic.star;

public class star1 {
    public static void main(String[] args) {
        //makeStarHierarchy(7);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j<i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void makeStarHierarchy(int n) {
        StringBuilder sb = new StringBuilder();
        int current = n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-current;j++){
                sb.append(" ");
            }

            for(int k=0;k<current;k++){
                sb.append("*");
            }

            sb.append("\n");
            current--;
        }

        System.out.println(sb.toString());
    }
}
