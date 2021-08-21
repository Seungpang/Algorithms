package BJ;
//다이내믹 프로그래밍
//연속합 2

import java.util.Scanner;

public class No13398 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = a[i];
            if (i > 0 && dp[i] < dp[i - 1] + a[i]) {
                dp[i] = dp[i - 1] + a[i];
            }
        }

        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = a[i];
            if (i < n - 1 && dp2[i] < dp2[i + 1] + a[i]) {
                dp2[i] = dp2[i + 1] + a[i];
            }
        }

        int result = dp[0];
        for (int i=1; i<n; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        for (int i = 1; i < n-1; i++) {
            if (result < dp[i-1] + dp2[i+1] ) {
                result = dp[i-1] + dp2[i+1];
            }
        }
        System.out.println(result);
    }
}
