package BJ;
// 호텔

import java.util.Arrays;
import java.util.Scanner;

public class No1106 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] cost = new int[n];
        int[] customer = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
            customer[i] = sc.nextInt();
        }

        int[] dp = new int[c + 101];
        Arrays.fill(dp, 10000001);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = customer[i]; j <= c+100; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
