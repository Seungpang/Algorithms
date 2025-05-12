package BJ;
// 암호코드

import java.util.Scanner;

public class No2011 {

    static final int MOD = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }

            int twoDigit = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
