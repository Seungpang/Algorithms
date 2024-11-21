package BJ;
// XOR 카드 게임

import java.util.Arrays;
import java.util.Scanner;

public class No1414 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (dp[i - 2] != -1) {
                int x = cards[i - 2] ^ cards[i - 1];
                int score = dp[i - 2] + Integer.bitCount(x);
                dp[i] = Math.max(dp[i], score);
            }

            if (i >= 3 && dp[i - 3] != -1) {
                int x = cards[i-3] ^ cards[i-2] ^ cards[i-1];
                int score = dp[i-3] + Integer.bitCount(x);
                dp[i] = Math.max(dp[i], score);
            }
        }

        System.out.println(dp[n] == -1 ? 0 : dp[n]);
    }
}
