package BJ;

import java.util.Scanner;
// 타일 채우기 3

public class No14852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        final int MOD = 1000000007;

        long[][] dp = new long[1000001][2];
        dp[0][0] = 1;
        dp[1][0] = 2;
        dp[2][0] = 7;

        for (int i = 3; i <= N; i++) {
            dp[i][1] = (dp[i - 3][0] + dp[i - 1][1]) % MOD;
            dp[i][0] = (2 * dp[i - 1][0] + 3 * dp[i - 2][0] + 2 * dp[i][1]) % MOD;
        }

        System.out.println(dp[N][0]);
    }
}
