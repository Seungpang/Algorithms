package BJ;
//다이내믹 프로그래밍
//쉬운 계단 수

import java.util.Arrays;
import java.util.Scanner;

public class No10844 {

    static long[][] dp;
    static long mod = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                dp[i][j] = 0;
                if (j-1>=0) dp[i][j] += dp[i-1][j-1];
                if (j+1<=9) dp[i][j] += dp[i-1][j+1];
                dp[i][j] %= mod;
            }
        }
        System.out.println(Arrays.stream(dp[n]).sum() % mod);
    }
}
