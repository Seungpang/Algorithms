package BJ;
// 최대 정사각형

import java.util.Scanner;

public class No4095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] map;
        int[][] dp;
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }

            map = new int[n][m];
            dp = new int[n + 1][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=m; j++) {
                    if (map[i-1][j-1] != 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            System.out.println(max);
        }
    }
}
