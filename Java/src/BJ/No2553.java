package BJ;
// 마지막 팩토리얼 수

import java.util.Scanner;

public class No2553 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[20001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;
        for (int i = 5; i <= N; i++) {
            if (i % 5 == 0) {
                int q = i / 5;
                dp[i] = ((int) Math.pow(2, q % 4) * dp[q]) % 10;
            } else {
                int before = (i / 5) * 5;
                int result = 1;
                for (int j = i; j > before; j--) {
                    result *= (j % 10);
                }
                result *= dp[before];
                dp[i] = result % 10;
            }
        }

        System.out.println(dp[N]);
    }
}
