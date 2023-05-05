package BJ;
// 사과나무

import java.util.Scanner;

public class No20002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n + 1][n + 1];
        int[][] preSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i-1][j-1] + a[i][j];
            }
        }

        int max = preSum[1][1];
        int temp = 0;
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i < n-k+1; i++) {
                for (int j = 1; j < n-k+1; j++) {
                    temp = preSum[i + k][j + k] - preSum[i - 1][j + k] - preSum[i + k][j - 1] + preSum[i - 1][j - 1];
                    max = Math.max(max, temp);
                }
            }
        }

        System.out.println(max);
    }
}
