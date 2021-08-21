package BJ;
//다이내믹 프로그래밍
//타일 채우기

import java.util.Scanner;

public class No2133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i=2; i<=n; i+=2) {
            dp[i] = dp[i - 2] * 3;
            for (int j=i-4; j>=0; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }
        System.out.println(dp[n]);
    }
}
