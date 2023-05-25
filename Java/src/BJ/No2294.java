package BJ;
// 동전 2

import java.util.Arrays;
import java.util.Scanner;

public class No2294 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for (int t = 0; t < n; t++) {
            int coin = sc.nextInt();
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        if (dp[k] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
