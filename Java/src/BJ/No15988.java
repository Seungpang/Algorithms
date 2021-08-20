package BJ;
//다이내믹 프로그래밍
//1, 2, 3 더하기 3

import java.util.Scanner;

public class No15988 {

    static final long mod = 1000000009L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[1000001];
        dp[0] = 1;
        for (int i=1; i<=1000000; i++) {
            for (int j=1; j<=3; j++) {
                if (i-j >= 0) {
                    dp[i] += dp[i-j];
                }
            }
            dp[i] %= mod;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
