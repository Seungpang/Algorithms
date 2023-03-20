package Programmers;

public class PG12914 {

    public static void main(String[] args) {
        final PG12914 pg12914 = new PG12914();
        System.out.println(pg12914.solution(2000));
    }

    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];
    }
}
