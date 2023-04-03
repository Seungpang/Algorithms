package BJ;
//궁금한 민호
// 플로이드 워셜

import java.util.Scanner;

public class No1507 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        int[][] units = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isUnit = true;
                for (int k = 1; k <= n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int tmp = dist[i][k] + dist[k][j];
                    if (tmp < dist[i][j]) {
                        System.out.println("-1");
                        return;
                    } else if (tmp == dist[i][j]) {
                        isUnit = false;
                    }
                }
                if (isUnit) {
                    units[i][j] = units[j][i] = 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (units[i][j] == 1) {
                    result += dist[i][j];
                }
            }
        }
        System.out.println(result);
    }
}
