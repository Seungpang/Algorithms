package BJ;
// 맥주 마시면서 걸어가기

import java.util.Scanner;

public class No9025 {

    static boolean isArrive;
    static Point festival;
    static Point[] store;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Point start = new Point(sc.nextInt(), sc.nextInt());
            store = new Point[n];
            for (int j = 0; j < n; j++) {
                store[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            festival = new Point(sc.nextInt(), sc.nextInt());

            boolean[] visited = new boolean[n];
            isArrive = false;
            dfs(start.x, start.y, visited);

            if (isArrive) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
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

    public static void dfs(int x, int y, boolean[] visited) {
        if (isArrive) {
            return;
        }

        if (Math.abs(x - festival.x) + Math.abs(y - festival.y) <= 20 * 50) {
            isArrive = true;
            return;
        }

        for (int i = 0; i < store.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (Math.abs(x - store[i].x) + Math.abs(y - store[i].y) > 20 * 50) {
                continue;
            }
            visited[i] = true;
            dfs(store[i].x, store[i].y, visited);
        }
    }
}
