package BJ;
// 행성 터널

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No2887 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Planet> planets =new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new Planet(x, y, z, i));
        }

        for (int i = 0; i < 3; i++) {
            final int axis = i;
            planets.sort((p1, p2) -> {
                if (axis == 0) return Integer.compare(p1.x, p2.x);
                if (axis == 1) return Integer.compare(p1.y, p2.y);
                return Integer.compare(p1.z, p2.z);
            });

            for (int j = 1; j < n; j++) {
                Planet p1 = planets.get(j - 1);
                Planet p2 = planets.get(j);
                int cost = (axis == 0) ? Math.abs(p1.x - p2.x) :
                        (axis == 1) ? Math.abs(p1.y - p2.y) :
                                Math.abs(p1.z - p2.z);
                edges.add(new Edge(cost, p1.id, p2.id));
            }
        }

        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        long totalCost = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                totalCost += edge.cost;
                edgeCount++;
                if (edgeCount == n - 1) break;
            }
        }

        System.out.println(totalCost);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static class Planet {
        int x, y, z, id;

        public Planet(final int x, final int y, final int z, final int id) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.id = id;
        }
    }

    static class Edge implements Comparable<Edge> {
        int cost, from, to;

        public Edge(final int cost, final int from, final int to) {
            this.cost = cost;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.cost - o.cost;
        }
    }
}
