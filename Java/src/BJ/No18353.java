package BJ;
// 병사 배치하기

import java.util.Arrays;
import java.util.Scanner;

public class No18353 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            power[i] = scanner.nextInt();
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (power[j] > power[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int len : dp) {
            maxLength = Math.max(maxLength, len);
        }

        System.out.println(N - maxLength);
    }
}
