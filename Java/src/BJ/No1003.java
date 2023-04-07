package BJ;
// 피보나치 함수

import java.util.Scanner;

public class No1003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] dp = new int[45][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
