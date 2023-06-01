package BJ;
// 알약

import java.util.Scanner;

public class No4811 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 30; i++) {
            long cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt += dp[j] * dp[i - 1 - j];
            }
            dp[i] = cnt;
        }

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            System.out.println(dp[n]);
        }
    }
}
