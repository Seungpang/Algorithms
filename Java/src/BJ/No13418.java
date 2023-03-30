package BJ;
// 학교 탐방하기
// 최소 신장 트리

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No13418 {
    static int[] parent;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i <= m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            pq.offer(new Edge(start, end, value));
            pq2.offer(new Edge(start, end, value));
        }

        solve(n, pq, true);

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        solve(n, pq2, false);

        System.out.println(result);
    }

    private static void solve(final int n, final PriorityQueue<Edge> pq, boolean isMax) {
        int useEdge = 0;
        int sum = 0;
        while (useEdge < n) {
            Edge now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                if (now.value == 0) {
                    sum++;
                }
                useEdge++;
            }
        }
        if (isMax) {
            result += sum * sum;
        } else {
            result -= sum * sum;
        }
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

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int value;

        public Edge(final int start, final int end, final int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e) {
            return this.value - e.value;
        }
    }
}
