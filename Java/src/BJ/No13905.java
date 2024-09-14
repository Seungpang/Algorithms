package BJ;
// 세부

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No13905 {

    static int[] parent;
    static PriorityQueue<Edge> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        q = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.offer(new Edge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;

        while (!q.isEmpty() && useEdge < N - 1) {
            if (find(start) == find(end)) {
                break;
            }
            Edge now = q.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = now.v;
                useEdge++;
            }
        }

        System.out.println(find(start) == find(end) ? result : 0);
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static class Edge implements Comparable<Edge> {
        int s,e, v;

        public Edge(final int s, final int e, final int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(final Edge o) {
            return o.v - this.v;
        }
    }
}
