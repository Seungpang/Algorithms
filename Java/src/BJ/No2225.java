package BJ;
//다이내믹 프로그래밍
//합분해


import java.util.Scanner;

public class No2225 {

    static long mod = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] dp = new long[k+1][n+1];

        dp[0][0] = 1L;
        for (int i=1; i<=k; i++) {
            for (int j=0; j<=n; j++) {
                for (int l=0; l<=j; l++) {
                    dp[i][j] += dp[i - 1][j - l];
                    dp[i][j] %= mod;
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
