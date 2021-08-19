package BJ;
//다이내믹 프로그래밍
//카드 구매하기

import java.util.Scanner;

public class No11052 {

    static int[] p;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n + 1];
        dp = new int[n + 1];

        for (int i=1; i<=n; i++) {
            p[i] = sc.nextInt();
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j <=i; j++) {
                if (dp[i] < dp[i-j] + p[j]) {
                    dp[i] = dp[i - j] + p[j];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
