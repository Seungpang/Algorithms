package BJ;
// 파티
// 다익스트라

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1238 {

    static List<Edge>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[start].add(new Edge(end, value));
        }

        int result = 0;
        for (int start = 1; start <= n; start++) {
            result = Math.max(result, solve(start, x) + solve(x, start));
        }
        System.out.println(result);
    }

    public static int solve(int start, int end) {
        int[] dist = new int[1001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (dist[now.end] != now.value) {
                continue;
            }
            for (Edge edge : arr[now.end]) {
                if (dist[edge.end] > dist[now.end] + edge.value) {
                    dist[edge.end] = dist[now.end] + edge.value;
                    pq.offer(new Edge(edge.end, dist[edge.end]));
                }
            }
        }
        return dist[end];
    }

    static class Edge implements Comparable<Edge> {
        int end, value;

        public Edge(final int end, final int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(final Edge o) {
            return this.value - o.value;
        }
    }
}
