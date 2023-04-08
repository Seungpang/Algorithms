package BJ;
// 가장 큰 정사각형

import java.util.Scanner;

public class No1915 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }
        int[][] dp = new int[1005][1005];

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result * result);
    }
}
