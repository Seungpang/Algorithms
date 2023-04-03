package BJ;
// 택배
// 플로이드 워셜

import java.util.Arrays;
import java.util.Scanner;

public class No1719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];
        for (int i=1; i<=n; i++) {
            Arrays.fill(dist[i], 1000000001);
            dist[i][i] = 0;
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            dist[start][end] = value;
            dist[end][start] = value;
            next[start][end] = end;
            next[end][start] = start;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (next[i][j] == 0) {
                    System.out.print("- ");
                } else {
                    System.out.print(next[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
