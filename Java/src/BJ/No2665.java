package BJ;
// 미로만들기

import java.util.PriorityQueue;
import java.util.Scanner;

public class No2665 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Point now = pq.poll();

            if (now.x == n - 1 && now.y == n - 1) {
                System.out.println(now.value);
                return;
            }
            for (int[] dir : dirs) {
                int nx = now.x + dir[0];
                int ny = now.y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 0) {
                        pq.offer(new Point(nx, ny, now.value + 1));
                    } else {
                        pq.offer(new Point(nx, ny, now.value));
                    }
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x,y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }
}
