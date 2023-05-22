package BJ;
// 진우의 민트초코우유

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No20208 {

    static int result, n, m, h;
    static int[][] map;
    static boolean[] visited;
    static List<Point> milks;
    static Point house;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();
        map = new int[n][n];
        milks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    house = new Point(i, j);
                } else if (map[i][j] == 2) {
                    milks.add(new Point(i, j));
                }
            }
        }
        visited = new boolean[milks.size()];
        for (int i = 0; i < milks.size(); i++) {
            Point milk = milks.get(i);
            int dist = Math.abs(house.x - milk.x) + Math.abs(house.y - milk.y);

            if (dist <= m) {
                go(milk, i, m - dist + h, 1);
            }
        }
        System.out.println(result);
    }

    static void go(Point now, int idx, int hp, int count) {
        visited[idx] = true;

        for (int i = 0; i < milks.size(); i++) {
            if (!visited[i]) {
                Point next = milks.get(i);
                int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);

                if (dist <= hp) {
                    go(next, i, hp - dist + h, count + 1);
                }
            }
        }

        int dist = Math.abs(now.x - house.x) + Math.abs(now.y - house.y);

        if (dist <= hp) {
            result = Math.max(result, count);
        }
        visited[idx] = false;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
