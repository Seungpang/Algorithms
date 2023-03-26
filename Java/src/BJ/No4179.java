package BJ;
// 불!

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No4179 {

    static char[][] map;
    static int[][] fireTime;
    static int[][] dist;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        map = new char[r][c];
        fireTime = new int[r][c];
        dist = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(fireTime[i], -1);
            Arrays.fill(dist[i], -1);
        }
        Queue<Point> fireQ = new LinkedList<>();
        Queue<Point> q = new LinkedList<>();
        sc.nextLine();
        for (int i = 0; i < r; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'F') {
                    fireQ.offer(new Point(i, j));
                    fireTime[i][j] = 0;
                }
                if (map[i][j] == 'J') {
                    q.offer(new Point(i, j));
                    dist[i][j] = 0;
                }
            }
        }
        while (!fireQ.isEmpty()) {
            Point now = fireQ.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (fireTime[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                fireTime[nx][ny] = fireTime[now.x][now.y] + 1;
                fireQ.offer(new Point(nx, ny));
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    System.out.println(dist[now.x][now.y] + 1);
                    return;
                }
                if (dist[nx][ny] >= 0 || map[nx][ny] == '#') {
                    continue;
                }
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= dist[now.x][now.y] + 1) {
                    continue;
                }
                dist[nx][ny] = dist[now.x][now.y] + 1;
                q.offer(new Point(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
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
