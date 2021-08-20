package BJ;
//다이내믹 프로그래밍
//연속합

import java.util.Scanner;

public class No1912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) {
            dp[i] = a[i];
            if (i == 0) {
                continue;
            }
            if (dp[i] < dp[i-1] + a[i]) {
                dp[i] = dp[i - 1] + a[i];
            }
        }

        int result = dp[0];
        for (int i=0; i<n; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        System.out.println(result);
    }
}
