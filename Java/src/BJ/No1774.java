package BJ;
// 우주신과 교감
// 최소 신장 트리
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1774 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (find(start) != find(end)) {
                union(start, end);
                cnt++;
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                Point point = points.get(i - 1);
                pq.offer(new Edge(i, j, point.calculate(points.get(j - 1))));
            }
        }

        int useEdge = cnt;
        double result = 0;
        while (useEdge < n - 1) {
            Edge now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                System.out.println(now.value);
                useEdge++;
            }
        }
        System.out.printf("%.2f", result);
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static class Point {
        int x, y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public double calculate(Point point) {
            long dx = ((long) this.x) - point.x;
            long dy = ((long) this.y) - point.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        double value;

        public Edge(final int start, final int end, final double value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            return Double.compare(this.value, e.value);
        }
    }
}
