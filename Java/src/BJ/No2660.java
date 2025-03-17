package BJ;
// 회장뽑기

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class No2660 {

    static final int INF = 100001;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) {
                break;
            }
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] score = new int[n + 1];
        int minScore = INF;
        for (int i = 1; i <= n; i++) {
            int maxDist = 0;
            for (int j = 1; j <= n; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
            score[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (score[i] == minScore) {
                result.add(i);
            }
        }

        System.out.println(minScore + " " + result.size());
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
