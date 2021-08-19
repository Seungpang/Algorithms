package BJ;
//다이내믹 프로그래밍
//1, 2, 3 더하기 5

import java.util.Scanner;

public class No15990 {

    static final long mod = 1000000009L;
    static long[][] dp = new long[100001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i=1; i<=100000; i++) {
            if (i-1 >=0) {
                dp[i][1] = dp[i - 1][2] + dp[i - 1][3];
                if (i==1) {
                    dp[i][1] = 1;
                }
            }
            if (i-2 >=0) {
                dp[i][2] = dp[i - 2][1] + dp[i - 2][3];
                if (i==2) {
                    dp[i][2] = 1;
                }
            }
            if (i-3>=0) {
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2];
                if (i==3) {
                    dp[i][3] = 1;
                }
            }
            dp[i][1] %= mod;
            dp[i][2] %= mod;
            dp[i][3] %= mod;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println((dp[n][1] + dp[n][2] + dp[n][3])%mod);
        }
    }
}
