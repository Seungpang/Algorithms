package BJ;
// 선분 그룹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2162 {

    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Line {
        Point p1, p2;
        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            long x1 = Long.parseLong(input[0]);
            long y1 = Long.parseLong(input[1]);
            long x2 = Long.parseLong(input[2]);
            long y2 = Long.parseLong(input[3]);
            lines[i] = new Line(new Point(x1, y1), new Point(x2, y2));
        }

        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (doesIntersect(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        int groupCount = 0;
        int maxGroupSize = 0;
        for (int i = 0; i < N; i++) {
            if (find(i) == i) {
                groupCount++;
                maxGroupSize = Math.max(maxGroupSize, size[i]);
            }
        }

        System.out.println(groupCount);
        System.out.println(maxGroupSize);
    }

    static boolean doesIntersect(Line l1, Line l2) {
        int ccw1 = ccw(l1.p1, l1.p2, l2.p1) * ccw(l1.p1, l1.p2, l2.p2);
        int ccw2 = ccw(l2.p1, l2.p2, l1.p1) * ccw(l2.p1, l2.p2, l1.p2);

        if (ccw1 == 0 && ccw2 == 0) {
            return isOverlapping(l1, l2);
        }

        return ccw1 <= 0 && ccw2 <= 0;
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }

    static boolean isOverlapping(Line l1, Line l2) {
        return Math.min(l1.p1.x, l1.p2.x) <= Math.max(l2.p1.x, l2.p2.x) &&
                Math.min(l2.p1.x, l2.p2.x) <= Math.max(l1.p1.x, l1.p2.x) &&
                Math.min(l1.p1.y, l1.p2.y) <= Math.max(l2.p1.y, l2.p2.y) &&
                Math.min(l2.p1.y, l2.p2.y) <= Math.max(l1.p1.y, l1.p2.y);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
        }
    }
}
