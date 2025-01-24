package BJ;
// 악덕 영주 혜유

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No20010 {

    static int[] parent;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        parent = new int[N];
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        Collections.sort(edges);
        int result = kruskal(N, edges);

        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                graph[edge.start].add(new Edge(edge.start, edge.end, edge.value));
                graph[edge.end].add(new Edge(edge.end, edge.start, edge.value));
            }
        }
        int maxResult = findDiameter(N);

        System.out.println(result);
        System.out.println(maxResult);
    }

    static int kruskal(int n, List<Edge> edges) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        int result = 0;
        for (Edge edge : edges) {
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                result += edge.value;
                useEdge++;

                if (useEdge == n - 1) {
                    break;
                }
            }
        }
        return result;
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    static int findDiameter(int n) {
        int[] firstBfs = bfs(0, n);
        int foundNode = firstBfs[0];
        int[] secondBfs = bfs(foundNode, n);
        return secondBfs[1];
    }

    static int[] bfs(int start, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(new int[]{start, 0});
        visited[start] = true;
        int farthestNode = start;
        int maxDistance = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int dist = curr[1];
            if (dist > maxDistance) {
                maxDistance = dist;
                farthestNode = node;
            }

            for (Edge edge : graph[node]) {
                if (!visited[edge.end]) {
                    visited[edge.end] = true;
                    q.offer(new int[]{edge.end, dist + edge.value});
                }
            }
        }

        return new int[]{farthestNode, maxDistance};
    }

    static class Edge implements Comparable<Edge> {

        int start, end, value;

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
