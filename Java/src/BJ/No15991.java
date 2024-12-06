package BJ;

import java.util.Scanner;

public class No15991 {

    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] testCases = new int[T];

        int maxN = 0;
        for (int i = 0; i < T; i++) {
            testCases[i] = sc.nextInt();
            maxN = Math.max(maxN, testCases[i]);
        }


        // DP 배열 초기화
        long[] dp = new long[maxN + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        for (int i = 6; i <= maxN; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % MOD;
        }

        for (int n : testCases) {
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
