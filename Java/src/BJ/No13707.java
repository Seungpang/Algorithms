package BJ;
// 합분해 2

import java.util.Scanner;

public class No13707 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
