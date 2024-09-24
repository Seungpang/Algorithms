package BJ;
// 로또

import java.util.Arrays;
import java.util.Scanner;

public class No2758 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[][] dp = new long[n+1][m+1];
            for (int j = 1; j <= m; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    for (int k = 1; k <= j / 2; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }

            System.out.println(Arrays.stream(dp[n]).sum());
        }
    }
}
