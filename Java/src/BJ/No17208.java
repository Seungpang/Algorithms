package BJ;
// 카우버거 알바생

import java.util.Scanner;

public class No17208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][] orders = new int[n][2];
        for (int i = 0; i < n; i++) {
            orders[i][0] = sc.nextInt();
            orders[i][1] = sc.nextInt();
        }
        int[][] dp = new int[m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= orders[i][0]; j--) {
                for (int l = k; l >= orders[i][1]; l--) {
                    dp[j][l] = Math.max(dp[j][l], dp[j - orders[i][0]][l - orders[i][1]] + 1);
                }
            }
        }

        System.out.println(dp[m][k]);
    }
}
