package BJ;
// 유닛 이동시키기

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2194 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map;
    static boolean[][] visited;
    static Point start, end;
    static int n, m, a, b, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = 1;
        }

        visited = new boolean[n][m];

        start = new Point(sc.nextInt() - 1, sc.nextInt() - 1, 0);
        end = new Point(sc.nextInt() - 1, sc.nextInt() - 1, 0);

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == end.x && now.y == end.y) {
                return now.count;
            }
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (isPossible(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, now.count + 1));
                }
            }
        }
        return -1;
    }

    static boolean isPossible(int x, int y) {
        for (int nx = x; nx < x + a; nx++) {
            for (int ny = y; ny < y + b; ny++) {
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
