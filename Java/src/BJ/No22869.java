package BJ;
// 징검다리 건너기 (small)

import java.util.Scanner;

public class No22869 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] stones = new int[N];
        for (int i = 0; i < N; i++) {
            stones[i] = sc.nextInt();
        }

        boolean[] dp = new boolean[N];
        dp[0] = true;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && (j - i) * (1 + Math.abs(stones[i] - stones[j])) <= K) {
                    dp[j] = true;
                    break;
                }
            }
        }

        System.out.println(dp[N-1] ? "YES" : "NO");
    }
}
