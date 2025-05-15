package BJ;
// 계단 수

import java.util.Scanner;

public class No1562 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int MOD = 1_000_000_000;

        long[][][] dp = new long[N + 1][10][1 << 10];

        for (int digit = 1; digit <= 9; digit++) {
            dp[1][digit][1 << digit] = 1;
        }

        for (int length = 2; length <= N; length++) {
            for (int digit = 0; digit <= 9; digit++) {
                for (int state = 0; state < (1 << 10); state++) {
                    if (digit > 0) {
                        dp[length][digit][state | (1 << digit)] += dp[length - 1][digit - 1][state];
                        dp[length][digit][state | (1 << digit)] %= MOD;
                    }
                    if (digit < 9) {
                        dp[length][digit][state | (1 << digit)] += dp[length - 1][digit + 1][state];
                        dp[length][digit][state | (1 << digit)] %= MOD;
                    }
                }
            }
        }

        long result = 0;
        for (int digit = 0; digit <= 9; digit++) {
            result = (result + dp[N][digit][(1 << 10) - 1]) % MOD;
        }

        System.out.println(result);
    }
}
