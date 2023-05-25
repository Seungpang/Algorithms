package BJ;
// 동전 1

import java.util.Scanner;

public class No2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k + 1];
        for (int t = 0; t < n; t++) {
            int coin = sc.nextInt();
            for (int i = 1; i <= k; i++) {
                if (i - coin > 0) {
                    dp[i] = dp[i] + dp[i - coin];
                } else if (i - coin == 0) {
                    dp[i]++;
                }
            }
        }
        System.out.println(dp[k]);
    }
}
