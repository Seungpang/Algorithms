package BJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No20183 {
    static List<Edge>[] graph;
    static int N, M, A, B;
    static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextLong();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            graph[u].add(new Edge(v, cost));
            graph[v].add(new Edge(u, cost));
            maxCost = Math.max(maxCost, cost);
        }

        int result = binarySearch(1, maxCost);
        System.out.println(result == -1 ? -1 : result);
    }

    static int binarySearch(int left, int right) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canReach(mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    static boolean canReach(int maxCost) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] costs = new long[N + 1];
        Arrays.fill(costs, Long.MAX_VALUE);

        pq.offer(new long[]{A, 0});
        costs[A] = 0;

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            int node = (int) current[0];
            long cost = current[1];

            if (node == B) return true;
            if (cost > costs[node]) continue;

            for (Edge edge : graph[node]) {
                if (edge.cost > maxCost) continue;
                long newCost = cost + edge.cost;
                if (newCost <= C && newCost < costs[edge.to]) {
                    costs[edge.to] = newCost;
                    pq.offer(new long[]{edge.to, newCost});
                }
            }
        }
        return false;
    }

    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
