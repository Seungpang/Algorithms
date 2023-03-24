package BJ;
// 빙산

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2573 {

    static int n, m;
    static int[][] a;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        int count = 0;
        while ((count = icebergNumber()) < 2) {
            if (count == 0) {
                answer = 0;
                break;
            }

            icebergMelt();
            answer++;
        }
        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int icebergNumber() {
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int i, int j, boolean[][] visited) {
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }
            if (a[nx][ny] != 0 && !visited[nx][ny]) {
                dfs(nx, ny, visited);
            }
        }
    }

    public static void icebergMelt() {
        Queue<Point> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != 0) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();

            int count = 0;
            int nx, ny;
            for (int[] dir : dirs) {
                nx = now.x + dir[0];
                ny = now.y + dir[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && a[nx][ny] == 0) {
                    count++;
                }
            }
            if (a[now.x][now.y] - count < 0) {
                a[now.x][now.y] = 0;
            } else {
                a[now.x][now.y] -= count;
            }
        }
    }
}
