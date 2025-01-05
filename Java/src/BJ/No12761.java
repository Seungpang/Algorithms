package BJ;
// 돌다리

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No12761 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.offer(new Point(N, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.num == M) {
                System.out.println(p.count);
                return;
            }

            int now = p.num;
            for (int next : new int[]{now + 1, now - 1, now + A, now - A, now + B, now - B, now * A, now * B}) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    q.offer(new Point(next, p.count + 1));
                }
            }
        }
    }

    static class Point {
        int num, count;

        public Point(final int num, final int count) {
            this.num = num;
            this.count = count;
        }
    }
}
