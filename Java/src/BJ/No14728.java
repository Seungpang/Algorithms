package BJ;
// 벼락치기

import java.util.Scanner;

public class No14728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] dp = new int[t + 1];

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int s = sc.nextInt();

            for (int time = t; time >= k; time--) {
                dp[time] = Math.max(dp[time], dp[time - k] + s);
            }
        }

        System.out.println(dp[t]);
    }
}
