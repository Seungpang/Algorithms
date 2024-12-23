package BJ;
// 개업 2

import java.util.Arrays;
import java.util.Scanner;

public class No13902 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] wokSize = new int[M];
        for (int i = 0; i < M; i++) {
            wokSize[i] = sc.nextInt();
        }

        boolean[] possibleMeals = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            if (wokSize[i] <= N) possibleMeals[wokSize[i]] = true;
            for (int j = i + 1; j < M; j++) {
                int sum = wokSize[i] + wokSize[j];
                if (sum <= N) possibleMeals[sum] = true;
            }
        }

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (possibleMeals[j] && i >= j && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}
