package BJ;
// 피보나치 수 5

import java.util.Scanner;

public class No10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[21];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= 20; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
