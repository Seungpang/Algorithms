package BJ;
// 텔레포트 3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No12908 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long xs = Long.parseLong(st.nextToken());
        long ys = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long xe = Long.parseLong(st.nextToken());
        long ye = Long.parseLong(st.nextToken());

        Point[] points = new Point[8];
        points[0] = new Point(xs, ys);
        points[1] = new Point(xe, ye);

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());
            points[2 + i * 2] = new Point(x1, y1);
            points[2 + i * 2 + 1] = new Point(x2, y2);
        }

        long[][] dist = new long[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                dist[i][j] = Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
            }
        }

        for (int i = 0; i < 3; i++) {
            int a = 2 + i * 2;
            int b = a + 1;
            dist[a][b] = Math.min(dist[a][b], 10);
            dist[b][a] = Math.min(dist[b][a], 10);
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println(dist[0][1]);
    }

    static class Point {
        long x, y;

        public Point(final long x, final long y) {
            this.x = x;
            this.y = y;
        }
    }
}
