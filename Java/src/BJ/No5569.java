package BJ;
// 출근 경로

import java.util.Scanner;

public class No5569 {

    static final int MOD = 100_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        int[][][][] dp = new int[w + 1][h + 1][2][2];
        for (int i = 1; i <= w; i++) {
            dp[i][1][0][0] = 1;
        }
        for (int j = 1; j <= h; j++) {
            dp[1][j][1][0] = 1;
        }

        for (int i = 2; i <= w; i++) {
            for (int j = 2; j <= h; j++) {
                dp[i][j][0][0] = (dp[i-1][j][0][0] + dp[i-1][j][0][1]) % MOD;
                dp[i][j][0][1] = dp[i - 1][j][1][0] % MOD;
                dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % MOD;
                dp[i][j][1][1] = dp[i][j - 1][0][0] % MOD;
            }
        }

        int result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % MOD;
        System.out.println(result);
    }
}
