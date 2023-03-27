package BJ;
// 다리 만들기

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2146 {

    static int[][] dist;
    static int[][] map;
    static int n;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        island();

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    dist[i][j] = 0;
                    q.offer(new Point(i, j));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == map[now.x][now.y]) {
                    continue;
                }
                if (map[nx][ny] != 0) {
                    ans = Math.min(ans, dist[nx][ny] + dist[now.x][now.y]);
                } else {
                    map[nx][ny] = map[now.x][now.y];
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        System.out.println(ans);
    }

    public static void island() {
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || map[i][j] == 0) {
                    continue;
                }
                Queue<Point> q = new LinkedList<>();
                q.offer(new Point(i, j));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Point now = q.poll();
                    map[now.x][now.y] = idx;
                    for (int[] dir : dirs) {
                        int nx = now.x + dir[0];
                        int ny = now.y + dir[1];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] == 0) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
                idx++;
            }
        }
    }

    static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
