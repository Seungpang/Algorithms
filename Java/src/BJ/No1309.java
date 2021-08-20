package BJ;
//다이내믹 프로그래밍
//동물원

import java.util.Scanner;

public class No1309 {

    static long[][] dp;
    static final int mod = 9901;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1][3];

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i=2; i<=n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);
    }
}
