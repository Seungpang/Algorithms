package BJ;
//다이내믹 프로그래밍
//가장 긴 바이토 부분 수열

import java.util.Scanner;

public class No11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int[] dp2 = new int[n];
        for (int i=n-1; i>=0; i--) {
            dp2[i] = 1;
            for (int j=i+1; j<n; j++) {
                if (a[i] > a[j] && dp2[i] < dp2[j]+1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }
        int result = dp[0] + dp2[0] - 1;
        for (int i=0; i<n; i++) {
            if (result < dp[i] + dp2[i] - 1) {
                result = dp[i] + dp2[i] - 1;
            }
        }
        System.out.println(result);
    }
}
