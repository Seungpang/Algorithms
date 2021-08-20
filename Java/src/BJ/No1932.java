package BJ;
//다이내믹 프로그래밍
//정수 삼각형

import java.util.Scanner;

public class No1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        dp[1][1] = a[1][1];
        for (int i=2; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + a[i][j];
            }
        }

        int result = dp[1][1];
        for (int i=1; i<=n; i++) {
            if (result < dp[n][i]) {
                result = dp[n][i];
            }
        }
        System.out.println(result);
    }
}
