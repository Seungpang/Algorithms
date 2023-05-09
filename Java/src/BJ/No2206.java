package BJ;
//bfs
//벽 부수고 이동하기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][m];
        int[][][] dist = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, 0));
        dist[0][0][0] = 1;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                int nz = now.z;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (dist[nx][ny][nz] == 0 && map[nx][ny] == 0) {
                        dist[nx][ny][nz] = dist[now.x][now.y][now.z] + 1;
                        q.offer(new Point(nx, ny, nz));
                    }
                    if (nz == 0 && map[nx][ny] == 1 && dist[nx][ny][nz] == 0) {
                        dist[nx][ny][nz + 1] = dist[now.x][now.y][now.z] + 1;
                        q.offer(new Point(nx, ny, nz + 1));
                    }
                }
            }
        }
        if (dist[n - 1][m - 1][0] != 0 && dist[n - 1][m - 1][1] != 0) {
            System.out.println(Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]));
        } else if (dist[n - 1][m - 1][0] != 0) {
            System.out.println(dist[n - 1][m - 1][0]);
        } else if (dist[n - 1][m - 1][1] != 0) {
            System.out.println(dist[n - 1][m - 1][1]);
        } else {
            System.out.println(-1);
        }
    }

    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
