package BJ;
// 파스칼 삼각형

import java.util.Scanner;

public class No15489 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();

        int[][] dp = new int[R + W][R + W];
        dp[0][0] = 1;

        for (int i = 1; i < R + W; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        int sum = 0;
        for (int i = 0; i < W; i++) {
            for (int j = 0; j <= i; j++) {
                sum += dp[R - 1 + i][C - 1 + j];
            }
        }
        System.out.println(sum);
    }
}
