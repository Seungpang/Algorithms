package BJ;
// 행성 연결
// 최소 신장 트리

import java.util.PriorityQueue;
import java.util.Scanner;

public class No16398 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        parent = new int[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = sc.nextInt();
                if (i < j) {
                    pq.offer(new Edge(i, j, value));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        long result = 0;
        while (useEdge < n - 1) {
            Edge now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }
        System.out.println(result);
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
        public int compareTo(final Edge e) {
            return this.value - e.value;
        }
    }
}
