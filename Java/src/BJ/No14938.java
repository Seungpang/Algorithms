package BJ;
// 서강그라운드
// 플로이드

import java.util.Arrays;
import java.util.Scanner;

public class No14938 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 100001);
            dist[i][i] = 0;
        }
        while (r-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            dist[start][end] = value;
            dist[end][start] = value;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 얻는 아이템 최대 개수 구하기
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j]  <= m) {
                    tmp += items[j];
                }
            }
            result = Math.max(tmp, result);
        }
        System.out.println(result);
    }
}
