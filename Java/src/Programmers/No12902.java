package Programmers;

public class No12902 {

    public static void main(String[] args) {
        final No12902 no12902 = new No12902();
        System.out.println(no12902.solution(4)); //11
    }

    public int solution(int n) {
        long[] dp = new long[5001];

        dp[0] = 1;
        for (int i=2; i<=n; i += 2) {
            dp[i] = dp[i-2] * 3;
            dp[i] %= 1000000007;
            for (int j=i-4; j>=0; j-=2) {
                dp[i] += dp[j] * 2;
                dp[i] %= 1000000007;
            }
        }
        return (int) dp[n];
    }
}
