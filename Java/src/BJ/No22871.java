package BJ;
// 징검다리 건너기 (large)

import java.util.Scanner;

public class No22871 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        long[] dp = new long[N];
        for (int i = 1; i < N; i++) {
            dp[i] = Long.MAX_VALUE;
        }

        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                long cost = (j - i) * (1 + Math.abs(arr[i] - arr[j]));
                long candidate = Math.max(dp[i], cost);
                dp[j] = Math.min(dp[j], candidate);
            }
        }

        System.out.println(dp[N - 1]);
    }
}
