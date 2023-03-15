package BJ;

import java.util.PriorityQueue;
import java.util.Scanner;

//최소 스패닝 트리
public class No1197 {

    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[v + 1];
        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            pq.add(new Edge(start, end, value));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < v - 1) {
            final Edge now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result += now.value;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
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
