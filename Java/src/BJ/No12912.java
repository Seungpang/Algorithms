package BJ;
// 트리 수정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No12912 {

    static int N;
    static ArrayList<Edge>[] adj;
    static long maxDiameter = 0;

    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static boolean[] visited;
    static long diameter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }

        HashSet<String> consideredEdges = new HashSet<>();
        for (int u = 0; u < N; u++) {
            for (Edge e : adj[u]) {
                int v = e.to;
                long w = e.cost;
                String edgeKey = Math.min(u, v) + "," + Math.max(u, v);
                if (consideredEdges.contains(edgeKey)) continue;
                consideredEdges.add(edgeKey);

                adj[u].remove(e);
                final int finalU = u;
                adj[v].removeIf(edge -> edge.to == finalU && edge.cost == w);

                visited = new boolean[N];
                diameter = 0;
                dfsDiameter(u);
                long d1 = diameter;

                visited = new boolean[N];
                diameter = 0;
                dfsDiameter(v);
                long d2 = diameter;

                long newDiameter = d1 + d2 + w;
                maxDiameter = Math.max(maxDiameter, newDiameter);

                adj[u].add(new Edge(v, w));
                adj[v].add(new Edge(u, w));
            }
        }

        System.out.println(maxDiameter);
    }

    static long dfsDiameter(int node) {
        visited[node] = true;
        long firstMax = 0, secondMax = 0;

        for (Edge e : adj[node]) {
            int next = e.to;
            long cost = e.cost;
            if (!visited[next]) {
                long dist = dfsDiameter(next) + cost;
                if (dist > firstMax) {
                    secondMax = firstMax;
                    firstMax = dist;
                } else if (dist > secondMax) {
                    secondMax = dist;
                }
            }
        }
        diameter = Math.max(diameter, firstMax + secondMax);
        return firstMax;
    }
}
