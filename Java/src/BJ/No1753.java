package BJ;
//최단경로

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1753 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();
        List<Edge>[] arr = new ArrayList[V + 1];
        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new Edge(v, w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K, 0));
        distance[K] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.vertex]) {
                continue;
            }
            visited[now.vertex] = true;
            for (Edge edge : arr[now.vertex]) {
                int next = edge.vertex;
                int value = edge.value;
                if (distance[next] > distance[now.vertex] + value) {
                    distance[next] = distance[now.vertex] + value;
                    pq.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge(final int vertex, final int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(final Edge e) {
            if (this.value > e.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
