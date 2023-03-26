package BJ;
// 붏

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No5427 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            int[][] map = new int[n][m];
            int[][] dist1 = new int[n][m];
            int[][] dist2 = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist1[i], -1);
                Arrays.fill(dist2[i], -1);
            }
            Queue<Point> q1 = new LinkedList<>();
            Queue<Point> q2 = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == '*') {
                        q1.offer(new Point(i, j));
                        dist1[i][j] = 0;
                    }
                    if (map[i][j] == '@') {
                        q2.offer(new Point(i, j));
                        dist2[i][j] = 0;
                    }
                }
            }

            while (!q1.isEmpty()) {
                Point now = q1.poll();
                for (int[] dir : dirs) {
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    if (dist1[nx][ny] >= 0 || map[nx][ny] == '#') {
                        continue;
                    }
                    dist1[nx][ny] = dist1[now.x][now.y] + 1;
                    q1.offer(new Point(nx, ny));
                }
            }

            boolean isPossible = false;
            while ((!q2.isEmpty()) && (!isPossible)) {
                Point now = q2.poll();
                for (int[] dir : dirs) {
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        sb.append(dist2[now.x][now.y] + 1).append("\n");
                        isPossible = true;
                        break;
                    }
                    if (dist2[nx][ny] >= 0 || map[nx][ny] == '#') {
                        continue;
                    }
                    if (dist1[nx][ny] <= dist2[now.x][now.y] + 1 && dist1[nx][ny] != -1) {
                        continue;
                    }
                    dist2[nx][ny] = dist2[now.x][now.y] + 1;
                    q2.offer(new Point(nx, ny));
                }
            }
            if (!isPossible) {
                sb.append("IMPOSSIBLE").append("\n");
            }
        }
        System.out.println(sb);
    }
    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
