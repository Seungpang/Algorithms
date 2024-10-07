package BJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No20007 {

    static ArrayList<Edge>[] graph;
    static int[] distances;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }

        distances = new int[N];
        dijkstra(Y);

        List<Integer> distanceList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i != Y) {
                if (distances[i] == INF || distances[i] * 2 > X) {
                    System.out.println(-1);
                    return;
                }
                distanceList.add(distances[i]);
            }
        }

        Collections.sort(distanceList);

        int days = 0;
        int index = 0;
        int size = distanceList.size();

        while (index < size) {
            days++;
            int dailyDistance = 0;

            while (index < size && dailyDistance + distanceList.get(index) * 2 <= X) {
                dailyDistance += distanceList.get(index) * 2;
                index++;
            }
        }

        System.out.println(days);
    }

    static void dijkstra(int start) {
        Arrays.fill(distances, INF);
        distances[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int here = current.to;

            if (distances[here] < current.weight) continue;

            for (Edge e : graph[here]) {
                if (distances[e.to] > distances[here] + e.weight) {
                    distances[e.to] = distances[here] + e.weight;
                    pq.offer(new Edge(e.to, distances[e.to]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}
