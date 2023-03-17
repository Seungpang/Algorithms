package Programmers;

public class PG12945 {

    public static void main(String[] args) {
        final PG12945 pg12945 = new PG12945();
        System.out.println(pg12945.solution(5));
    }

    public int solution(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }
}
