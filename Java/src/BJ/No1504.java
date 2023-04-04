package BJ;
// 특정한 최단 경로
// 다익스트라

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No1504 {
    static int[] dist;
    static List<Edge>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        arr = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        dist = new int[n + 1];


        while (e-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();
            arr[start].add(new Edge(end, value));
            arr[end].add(new Edge(start, value));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        long answer1 = solve(1, start) + solve(start, end) + solve(end, n);
        long answer2 = solve(1, end) + solve(end, start) + solve(start, n);
        long answer = Math.min(answer2, answer1);
        if (answer >= Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    public static long solve(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
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
