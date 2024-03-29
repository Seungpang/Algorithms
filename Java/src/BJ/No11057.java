package BJ;
//다이내믹 프로그래밍
//오르막 수

import java.util.Scanner;

public class No11057 {

    static int[][] dp;
    static int mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1][10];

        for (int i=0; i<=9; i++) dp[1][i] = 1;
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                for (int k=0; k<=j; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }
        long result = 0;
        for (int i=0; i<10; i++) result += dp[n][i];
        result %= mod;
        System.out.println(result);
    }
}
