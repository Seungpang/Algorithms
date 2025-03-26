package BJ;
// 1, 2, 3 더하기 7

import java.util.Scanner;

public class No15992 {

    static int MOD = 1_000_000_009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int m = 1; m <= 1000; m++) {
            for (int n = 1; n <= 1000; n++) {
                if (n - 1 >= 0) {
                    dp[n][m] = (dp[n][m] + dp[n - 1][m - 1]) % MOD;
                }
                if (n - 2 >= 0) {
                    dp[n][m] = (dp[n][m] + dp[n - 2][m - 1]) % MOD;
                }
                if (n - 3 >= 0) {
                    dp[n][m] = (dp[n][m] + dp[n - 3][m - 1]) % MOD;
                }
            }
        }

        while (testCase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(dp[n][m]);
        }
    }
}
