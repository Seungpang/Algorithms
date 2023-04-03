package BJ;
// 백양로 브레이크
// 플로이드 워셜

import java.util.Arrays;
import java.util.Scanner;

public class No11562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 1000000001);
            dist[i][i] = 0;
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            if (value == 1) {
                dist[start][end] = 0;
                dist[end][start] = 0;
            } else {
                dist[start][end] = 0;
                dist[end][start] = 1;
            }
        }

        for (int k=1; k<=n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int t = sc.nextInt();
        while (t-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(dist[start][end]);
        }
    }
}
