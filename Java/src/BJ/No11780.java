package BJ;
// 플로이드 2

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No11780 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dist = new int[n + 1][n + 1];
        int[][] next = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = 100001;
                }
            }
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            dist[start][end] = Math.min(dist[start][end], price);
            next[start][end] = end;
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
                if (dist[i][j] == 100001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == 100001) {
                    System.out.print("0\n");
                    continue;
                }
                Queue<Integer> path = new LinkedList<>();
                int st = i;
                while (st != j) {
                    path.offer(st);
                    st = next[st][j];
                }
                path.offer(j);
                System.out.print(path.size() + " ");
                for (int x : path) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }
    }
}
