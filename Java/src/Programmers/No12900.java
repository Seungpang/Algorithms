package Programmers;

public class No12900 {

    public static void main(String[] args) {
        final No12900 no12900 = new No12900();
        System.out.println(no12900.solution(4)); //5
    }

    public int solution(int n) {
        int[] dp = new int[60001];

        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
