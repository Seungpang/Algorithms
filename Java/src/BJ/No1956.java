package BJ;
// 운동
// 플로이드 워셜

import java.util.Arrays;
import java.util.Scanner;

public class No1956 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int[][] dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                Arrays.fill(dist[i], 1000000001);
                dist[i][i] = 0;
            }
        }

        while (e-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            dist[start][end] = value;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 사이클을 이루는 도로의 길이의 합이 최소인 것 구하기
        int result = 1000000001;
        for (int i = 1; i <= v; i++) {
            for (int j = i + 1; j <= v; j++) {
                result = Math.min(result, dist[i][j] + dist[j][i]);
            }
        }

        if (result == 1000000001) {
            result = -1;
        }
        System.out.println(result);
    }
}
