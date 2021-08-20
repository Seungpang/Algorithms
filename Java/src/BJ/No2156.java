package BJ;
//다이내믹 프로그래밍
//포도주 시식

import java.util.Scanner;

public class No2156 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n + 1];
//        for (int i=1; i<=n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = a[1];
//        if (n >=2) {
//            dp[2] = a[1] + a[2];
//        }
//        for (int i=3; i<=n; i++) {
//            dp[i] = dp[i - 1];
//            dp[i] = Math.max(dp[i], dp[i - 2] + a[i]);
//            dp[i] = Math.max(dp[i], dp[i - 3] + a[i - 1] + a[i]);
//        }
//        int result = dp[1];
//        for (int i=2; i<=n; i++) {
//            result = Math.max(result, dp[i]);
//        }
//        System.out.println(result);
//    }
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        dp = new int[n][3];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        dp[0][0] = 0;
        dp[0][1] = a[0];
        dp[0][2] = 0;
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + a[i];
            dp[i][2] = dp[i - 1][1] + a[i];
        }
        System.out.println(Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
    }
}
