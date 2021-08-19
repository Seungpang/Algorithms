package BJ;

import java.util.Scanner;

public class No9095_2 {

    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i=0; i<n; i++) {
            int m = sc.nextInt();
            System.out.println(dp[m]);
        }
    }
}
