package BJ;
// 통신망 분할

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17398 {

    static int[] parent;
    static int[] compSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        compSize = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            compSize[i] = 1;
        }

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(x, y);
        }

        boolean[] removed = new boolean[M];
        int[] removalOrder = new int[Q];
        for (int i = 0; i < Q; i++) {
            int idx = Integer.parseInt(br.readLine()) - 1;
            removed[idx] = true;
            removalOrder[i] = idx;
        }

        for (int i = 0; i < M; i++) {
            if (!removed[i]) {
                union(edges[i].start, edges[i].end);
            }
        }

        long result = 0;
        for (int i = Q - 1; i >= 0; i--) {
            int idx = removalOrder[i];
            int start = edges[idx].start;
            int end = edges[idx].end;
            int rootStart = find(start);
            int rootEnd = find(end);
            if (rootStart != rootEnd) {
                long cost = (long) compSize[rootStart] * compSize[rootEnd];
                result += cost;
                union(start, end);
            }
        }

        System.out.println(result);
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;
        if (compSize[rootA] < compSize[rootB]) {
            parent[rootA] = rootB;
            compSize[rootB] += compSize[rootA];
        } else {
            parent[rootB] = rootA;
            compSize[rootA] += compSize[rootB];
        }
    }

    static class Edge {
        int start, end;

        public Edge(final int start, final int end) {
            this.start = start;
            this.end = end;
        }
    }
}
