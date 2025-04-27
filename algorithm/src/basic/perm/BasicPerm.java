package basic.perm;

public class BasicPerm {
    public static void main(String[] args) {

    }

    static boolean np(int[] array) {
        // 3
        // 맨 뒤에서 출발
        int i = array.length - 1;

        // 뒤보다 앞이 크거나 같으면( 내림차순으로 정렬되어 있으면 ) 계속 가다가 그렇지 않으면 멈춘다.
        // 5 <-- 4 <-- 2 까지는 계속
        // 1 X 5 <-- 4 <-- 2
        while( i > 0 && array[i-1] >= array[i] ) --i;

        // 맨 앞까지 왔으면 종료
        if( i == 0 ) return false;

        // 현재 src[i-1] 이 src[i] 보다 작은 상태
        // src[i] 이후 항목 (src[i] 보다 작은) 과 src[i-1]과 비교 필요

        // 맨 뒤에서 출발
        int j = array.length - 1;
        // i 이전 항목 중 src[i-1] 보다 작은 것은 무시하고, 큰 것이 있으면 멈춤
        //  만약 큰 것이 있으면 그것과  없으면 src[i] 와 교환
        while( array[i-1] >= array[j]) --j;
        swap( array, i-1, j );

        // i 부터 맨 뒤까지 reverse
        int k = array.length - 1;
        while( i < k ) {
            swap(array, i++, k--);
        }
        return true;

    }
    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
