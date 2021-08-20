package BJ;
//다이내믹 프로그래밍
//가장 긴 증가하는 부분 수열

import java.util.Scanner;

public class No11053 {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        dp = new int[n];
        for (int i=0; i<n; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (a[j] < a[i] && dp[i] <dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
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
