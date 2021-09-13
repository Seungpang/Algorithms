package BJ;
//bfs
//데스나이트

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point2 {
    int x, y;
    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class No16948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n][n];
        int[] dx = {-2, -2, 0, 0, 2, 2};
        int[] dy = {-1, 1, -2, 2, -1, 1};
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Queue<Point2> q = new LinkedList<>();
        q.add(new Point2(r1, c1));

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        dist[r1][c1] = 0;
        while (!q.isEmpty()) {
            Point2 p = q.remove();
            int x = p.x;
            int y = p.y;
            for (int k=0; k<6; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new Point2(nx, ny));
                    }
                }
            }
        }
        System.out.println(dist[r2][c2]);
    }
}
