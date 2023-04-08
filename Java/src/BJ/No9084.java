package BJ;
// 동전

import java.util.Arrays;
import java.util.Scanner;

public class No9084 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] dp = new int[10005];
        int[] coins = new int[10005];
        while (t-- > 0) {
            Arrays.fill(dp, 0);
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                coins[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            dp[0] = 1;
            for (int i=0; i<n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
