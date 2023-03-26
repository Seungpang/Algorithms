package BJ;
// 유기농 배추

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1012 {

    static int m,n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            map = new int[m][n];
            visited = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] != 1 || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
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
