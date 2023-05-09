package BJ;
//그래프
//토마토

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No7576 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == 1) {
                    q.add(new Pair(i, j));
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (a[nx][ny] == 0 && dist[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (result < dist[i][j]) {
                    result = dist[i][j];
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] == 0 && dist[i][j] == -1) {
                    result = -1;
                }
            }
        }
        System.out.println(result);
    }

   static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
