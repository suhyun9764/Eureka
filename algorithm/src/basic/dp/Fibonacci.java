package basic.dp;

public class Fibonacci {
    public static void main(String[] args) {
        // #1. 단순 재귀 호출
//        System.out.println(fibo_rc(50));
        // #2. 메모이제이션
        long rcStart = System.nanoTime();
        System.out.println(fibo_rc_memoi(50));
        long rcEnd = System.nanoTime();
        System.out.println(rcEnd-rcStart);
        // #3. 동적 계획법 (점화식 + 메모이제이션)
        long dpStart = System.nanoTime();
        System.out.println(fibo_dp(50));
        long dpEnd = System.nanoTime();
        System.out.println(dpEnd-dpStart);

    }

    static long fibo_rc(int n){
        if(n==1||n==2)
            return 1;

        return fibo_rc(n-1) + fibo_rc(n-2);
    }

    static long[] memoi_rc = new long[51];

    static long fibo_rc_memoi(int n){
        if(n==1||n==2)
            return 1;
        // 이미 n에 대해 사전에 수행되고 기록된 결과가 존재하는 지 확인
        if(memoi_rc[n]>0) return memoi_rc[n];   // 이전 수행되고, 기록된 결과를 재활용
        return memoi_rc[n] = fibo_rc_memoi(n-1) + fibo_rc_memoi(n-2);
    }

    static long[] memoi_dp = new long[51];
    // 점화식을 세우고 앞부터 점화식을 단계별로 적용한 결과를 메모이제이션 자료구조에 저장, 활용
    private static long fibo_dp(int n) {
        if(n==1||n==2) return 1;

        memoi_dp[1] = 1;
        memoi_dp[2] = 1;

        for(int i=3;i<=n;i++){
            memoi_dp[i] = memoi_dp[i-1]+memoi_dp[i-2];
        }

        return memoi_dp[n];
    }

}


// 기본적인 완탐 문제에서 시간초과가 발생하는 경우
// 완탐 자체를 줄여야 한다.
// 1. 가지치기( 갈 필요가 없는 반복 탐색)
// 2. 메모이제이션 (반복적으로 수행되는 탐색)

// dp 풀이는 문제에서 점화식을 파악해야 적용할 수 있다.
// 현재 상태에서 미래 상태를 만든다고 고민하지말고
// 과거상태에서 현재상태로 만든다고 고민하기
// 점화식은 항상 이전 상태가 현재 상태를 만들지 못할 수도있다.