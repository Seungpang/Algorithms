package BJ;
// 직각 삼각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1711 {

    static class Point {
        long x, y;
        public Point(final long x, final long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        long count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (isRightAngle(points[i], points[j], points[k])) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    static boolean isRightAngle(Point p1, Point p2, Point p3) {
        long dist1 = distanceSquared(p1, p2);
        long dist2 = distanceSquared(p2, p3);
        long dist3 = distanceSquared(p3, p1);

        return (dist1 + dist2 == dist3) || (dist1 + dist3 == dist2) || (dist2 + dist3 == dist1);
    }

    static long distanceSquared(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
