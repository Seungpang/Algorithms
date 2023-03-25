package BJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1926 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static int n, m;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        int count = 0;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    max = Math.max(bfs(i, j), max);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int count = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();
            int nx, ny;
            for (int[] dir : dirs) {
                nx = now.x + dir[0];
                ny = now.y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    count++;
                }
            }
        }
        return count;
    }
}
