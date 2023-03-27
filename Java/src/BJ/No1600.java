package BJ;
// 말이 되고픈 원숭이

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1600 {

    static int[][][] dist;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dirsKnight = {{-1, 2}, {-2, 1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        dist = new int[n][m][k+1];
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        dist[0][0][0] = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.x;
            int y = now.y;
            int z = now.z;
            if (z < k) {
                for (int[] dir : dirsKnight) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (map[nx][ny] == 1) {
                        continue;
                    }
                    if (dist[nx][ny][z + 1] > 0) {
                        continue;
                    }
                    dist[nx][ny][z + 1] = dist[x][y][z] + 1;
                    q.offer(new Point(nx, ny, z + 1));
                }
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    continue;
                }
                if (dist[nx][ny][z] > 0) {
                    continue;
                }
                dist[nx][ny][z] = dist[now.x][now.y][now.z] + 1;
                q.offer(new Point(nx, ny, z));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            if (dist[n - 1][m - 1][i] > 0) {
                ans = Math.min(ans, dist[n - 1][m - 1][i]);
            }
        }
        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans - 1);
        } else {
            System.out.println(-1);
        }
    }

    static class Point {
        int x,y, z;

        public Point(final int x, final int y, final int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
