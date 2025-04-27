package basic.array;

public class Array2 {
    // Circular Array
    public static void main(String[] args) {
        char[] input = {'A','B','C','D','E','F','G'};
        int len = input.length;

        // 전체 길이의 2배 순회 출력
        {
            for (int i = 0; i < len * 2; i++) {
                System.out.print(input[i%len]+" ");
            }
            System.out.println();
        }

        // Circular Array
        // 'A','B','C','D','E','F','G'이 원을 그리고 있고, 'A' 시작해서 특정 수 만큼 출력
        {
            int total = 20;
            for(int i=0;i<total;i++){
                System.out.print(input[i%len]+" ");
            }
        }
    }
}
