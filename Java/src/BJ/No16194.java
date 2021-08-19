package BJ;
//다이내믹 프로그래밍
//카드 구매하기 2

import java.util.Scanner;

public class No16194 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        for (int i=1; i<=n; i++) {
            p[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        for (int i=1; i<=n; i++) {
            dp[i] = -1;
            for (int j=1; j<=i; j++) {
                if (dp[i] == -1 || dp[i] > dp[i-j] + p[j]) {
                    dp[i] = dp[i - j] + p[j];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
