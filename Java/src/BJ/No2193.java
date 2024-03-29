package BJ;
//다이내믹 프로그래밍
//이친수

import java.util.Scanner;

public class No2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[100];

        dp[1] = 1;
        dp[2] = 1;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
