package BJ;
//그래프
//나이트의 이동

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class No7562 {

    static int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], -1);
            }
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(startX, startY));
            dist[startX][startY] = 0;

            while (!q.isEmpty()) {
                Point now = q.poll();
                for (int[] dir : dirs) {
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (dist[nx][ny] != -1) {
                        continue;
                    }
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    q.offer(new Point(nx, ny));
                }
            }
            System.out.println(dist[endX][endY]);
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
