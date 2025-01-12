package BJ;
// 투자의 귀재 배주형

import java.util.Scanner;

public class No19947 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int Y = sc.nextInt();
        int[] dp = new int[Y + 1];
        dp[0] = H;
        for (int i = 1; i <= Y; i++) {
            dp[i] = (dp[i - 1] * 105) / 100;

            if (i >= 3) {
                dp[i] = Math.max(dp[i], (dp[i - 3] * 120) / 100);
            }

            if (i >= 5) {
                dp[i] = Math.max(dp[i], (dp[i - 5] * 135) / 100);
            }
        }

        System.out.println(dp[Y]);
    }
}
