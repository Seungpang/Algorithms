package BJ;
// 선분 교차 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17387 {
    static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Point p1 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point p2 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point p3 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point p4 = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(doesIntersect(p1, p2, p3, p4) ? 1 : 0);
    }

    static boolean doesIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);

        if (ccw1 == 0 && ccw2 == 0) {
            return isOverlapping(p1, p2, p3, p4);
        }

        return ccw1 <= 0 && ccw2 <= 0;
    }

    static int ccw(Point p1, Point p2, Point p3) {
        long result = (p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }

    static boolean isOverlapping(Point p1, Point p2, Point p3, Point p4) {
        return Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x) &&
                Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x) &&
                Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y) &&
                Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);
    }
}
