package BJ;
// 물대기
// 최소신장트리

import java.util.PriorityQueue;
import java.util.Scanner;

public class No1368 {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            pq.offer(new Edge(n + 1, i, sc.nextInt()));
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int value = sc.nextInt();
                if (i < j) {
                    pq.offer(new Edge(i, j, value));
                }
            }
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < n) {
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
