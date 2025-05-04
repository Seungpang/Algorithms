package BJ;
// Coins

import java.util.Scanner;

public class No3067 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int n = sc.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
            }

            int m = sc.nextInt();
            long[] dp = new long[m + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            System.out.println(dp[m]);
        }
    }
}
