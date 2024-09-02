package BJ;
// 거스름돈

import java.util.Arrays;
import java.util.Scanner;

public class No14916 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 5) {
            dp[5] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (i >= 2 && dp[i-2] != -1) {
                dp[i] = (dp[i] == -1) ? dp[i-2] + 1 : Math.min(dp[i], dp[i-2] + 1);
            }
            if (i >= 5 && dp[i-5] != -1) {
                dp[i] = (dp[i] == -1) ? dp[i-5] + 1 : Math.min(dp[i], dp[i-5] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
