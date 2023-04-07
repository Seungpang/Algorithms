package BJ;
// 계단 오르기

import java.util.Arrays;
import java.util.Scanner;

public class No2579 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] score = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            score[i] = sc.nextInt();
//        }
//        int[][] dp = new int[305][3];
//        if (n == 1) {
//            System.out.println(score[n]);
//            return;
//        }
//        dp[1][1] = score[1];
//        dp[1][2] = 0;
//        dp[2][1] = score[2];
//        dp[2][2] = score[1] + score[2];
//        for (int i = 3; i <= n; i++) {
//            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + score[i];
//            dp[i][2] = dp[i - 1][1] + score[i];
//        }
//        System.out.println(Math.max(dp[n][1], dp[n][2]));
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[1] = score[1];
        dp[2] = score[2];
        dp[3] = score[3];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 3]) + score[i];
        }

        System.out.println(Arrays.stream(score).sum() - Math.min(dp[n-1], dp[n-2]));
    }
}
