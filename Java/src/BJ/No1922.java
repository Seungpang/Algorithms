package BJ;

import java.util.PriorityQueue;
import java.util.Scanner;

// 최소 신장 트리
// 네트워크 연결
public class No1922 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            q.add(new Edge(start, end, value));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < n - 1) {
            final Edge now = q.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result = result + now.value;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
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
        public int compareTo(final Edge o) {
            return this.value - o.value;
        }
    }
}
