package BJ;
//다익스트라
//알고스팟

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1261 {

    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[][] dist;
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        arr = new int[n+1][m+1];
        dist = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        System.out.println(solve());
    }

    public static int solve() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(1, 1, 0));
        dist[1][1] = 0;
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            if (dist[now.x][now.y] != now.value) {
                continue;
            }
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx > n || ny > m || nx < 1 || ny < 1) {
                    continue;
                }
                if (now.value + arr[nx][ny] < dist[nx][ny]) {
                    dist[nx][ny] = now.value + arr[nx][ny];
                    pq.offer(new Point(nx, ny, dist[nx][ny]));
                }
            }
        }
        return dist[n][m];
    }

    static class Point implements Comparable<Point> {
        int x, y, value;

        public Point(final int start, final int end, final int value) {
            this.x = start;
            this.y = end;
            this.value = value;
        }

        @Override
        public int compareTo(final Point o) {
            return this.value - o.value;
        }
    }
}
